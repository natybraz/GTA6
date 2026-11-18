package com.seduc2.gta6.controller;

import com.seduc2.gta6.Service.VeiculoService;
import com.seduc2.gta6.entities.Veiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> getVeiculos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Veiculo> postVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo salvo = service.salvar(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> putVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Veiculo atualizado = service.atualizar(id, veiculo);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}