package com.seduc2.gta6.Service;

import com.seduc2.gta6.entities.Veiculo;
import com.seduc2.gta6.repository.VeiculoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    public Veiculo salvar(Veiculo veiculo) {
        if (veiculo.getModelo() == null || veiculo.getModelo().isBlank()) {
            throw new IllegalArgumentException("O modelo do veículo é obrigatório.");
        }
        return repository.save(veiculo);
    }
    public Veiculo atualizar(Long id, Veiculo dadosAtualizados) {
        Veiculo existente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado."));

        if (dadosAtualizados.getModelo() == null || dadosAtualizados.getModelo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O modelo do veículo é obrigatório.");
        }

        existente.setModelo(dadosAtualizados.getModelo());
        existente.setClasse(dadosAtualizados.getClasse());
        existente.setVelocidadeMax(dadosAtualizados.getVelocidadeMax());
        existente.setPreco(dadosAtualizados.getPreco());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado.");
        }
        repository.deleteById(id);
    }
}
