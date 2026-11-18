package com.seduc2.gta6.repository;


import com.seduc2.gta6.entities.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  PersonagemRepositories extends JpaRepository<Personagem, Integer> {
}