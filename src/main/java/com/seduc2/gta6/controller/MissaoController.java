package com.seduc2.gta6.controller;

import com.seduc2.gta6.Service.MissaoService;
import com.seduc2.gta6.entities.Missao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missoes")
@CrossOrigin(origins = "*")
public class MissaoController {

    private final MissaoService service;

    public MissaoController(MissaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Missao>> getMissoes() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    public ResponseEntity<Missao> postMissao(@RequestBody Missao missao) {
        Missao salva = service.salvar(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Missao> putMissao(@PathVariable Long id, @RequestBody Missao missao) {
        Missao atualizada = service.atualizar(id, missao);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMissao(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}