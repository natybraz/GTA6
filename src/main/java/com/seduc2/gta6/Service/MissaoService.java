
package com.seduc2.gta6.Service;

import com.seduc2.gta6.entities.Missao;
import com.seduc2.gta6.repository.MissaoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MissaoService {

    private final MissaoRepository repository;

    public MissaoService(MissaoRepository repository) {
        this.repository = repository;
    }

    public List<Missao> listarTodas() {
        return repository.findAll();
    }

    public Missao salvar(Missao missao) {
        if (missao.getTitulo() == null || missao.getTitulo().isBlank()) {
            throw new IllegalArgumentException("O título da missão é obrigatório.");
        }
        if (missao.getConcluida() == null) {
            missao.setConcluida(false);
        }
        return repository.save(missao);
    }
    public Missao atualizar(Long id, Missao dadosAtualizados) {
        Missao existente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Missão não encontrada."));

        if (dadosAtualizados.getTitulo() == null || dadosAtualizados.getTitulo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O título da missão é obrigatório.");
        }

        existente.setTitulo(dadosAtualizados.getTitulo());
        existente.setProtagonista(dadosAtualizados.getProtagonista());
        existente.setRecompensa(dadosAtualizados.getRecompensa());
        existente.setConcluida(Boolean.TRUE.equals(dadosAtualizados.getConcluida()));

        return repository.save(existente);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Missão não encontrada.");
        }
        repository.deleteById(id);
    }
}