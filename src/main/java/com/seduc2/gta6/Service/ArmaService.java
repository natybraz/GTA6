package com.seduc2.gta6.Service;

import com.seduc2.gta6.entities.Arma;
import com.seduc2.gta6.repository.ArmaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ArmaService {

    private final ArmaRepository repository;

    public ArmaService(ArmaRepository repository) {
        this.repository = repository;
    }

    public List<Arma> listarTodas() {
        return repository.findAll();
    }

    public Arma salvar(Arma arma) {
        if (arma.getNome() == null || arma.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome da arma é obrigatório.");
        }
        return repository.save(arma);
    }
    public Arma atualizar(Long id, Arma dadosAtualizados) {
        Arma existente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arma não encontrada."));

        if (dadosAtualizados.getNome() == null || dadosAtualizados.getNome().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome da arma é obrigatório.");
        }

        existente.setNome(dadosAtualizados.getNome());
        existente.setCategoria(dadosAtualizados.getCategoria());
        existente.setDano(dadosAtualizados.getDano());
        existente.setPreco(dadosAtualizados.getPreco());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Arma não encontrada.");
        }
        repository.deleteById(id);
    }
}
