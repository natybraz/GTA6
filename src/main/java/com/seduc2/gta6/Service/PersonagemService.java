package com.seduc2.gta6.Service;
import com.seduc2.gta6.entities.Personagem;
import com.seduc2.gta6.repository.PersonagemRepositories;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PersonagemService {
    private final PersonagemRepositories repo;

    public PersonagemService(PersonagemRepositories repo) {
        this.repo = repo;
    }
    public void cadastrar(Personagem p){
        repo.save(p);
    }
    public List<Personagem>mostrar(){
        return repo.findAll();
    }
    public void deletar(){

    }
    @Transactional
    public void alterar(int id, Personagem p){
        Personagem personagem = repo.getReferenceById(id);
        personagem.setNome(p.getNome());
        personagem.setApelido(p.getApelido());
        personagem.setCaterioga(p.getCaterioga());
        personagem.setDescrição(p.getDescrição());

    }

}
