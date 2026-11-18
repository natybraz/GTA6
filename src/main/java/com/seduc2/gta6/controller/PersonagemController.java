package com.seduc2.gta6.controller;


import com.seduc2.gta6.Service.PersonagemService;
import com.seduc2.gta6.entities.Personagem;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/personagens")
@RestController
public class PersonagemController {
    private final PersonagemService service;

    public PersonagemController(PersonagemService service) {
        this.service = service;
    }
    @PostMapping
    public void criar(@RequestBody Personagem p){
        service.cadastrar(p);
    }
    @GetMapping
    public List<Personagem>mostrar(){
        return service.mostrar();
    }
}







