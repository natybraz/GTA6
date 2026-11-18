package com.seduc2.gta6.controller;

import com.seduc2.gta6.Service.ArmaService;
import com.seduc2.gta6.entities.Arma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/armas")
public class ArmaController {

    private final ArmaService service;

    public ArmaController(ArmaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Arma>> getArmas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    public ResponseEntity<Arma> postArma(@RequestBody Arma arma) {
        Arma salva = service.salvar(arma);
        return ResponseEntity.status(HttpStatus.CREATED).body(salva);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Arma> putArma(@PathVariable Long id, @RequestBody Arma arma) {
        Arma atualizada = service.atualizar(id, arma);
        return ResponseEntity.ok(atualizada);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArma(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
