package com.seduc2.gta6.entities;

import jakarta.persistence.*;

@Entity
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  nome;
    private String  apelido;
    @Enumerated(EnumType.STRING)
    private CategoriaPersonagem caterioga;
    @Column(length = 500)
    private String  urlImagem;
    @Column(columnDefinition = "TEXT")
    private String  descrição;

    public Personagem() {}

    public Personagem(String nome, String apelido, CategoriaPersonagem caterioga, String urlImagem, String descrição) {
        this.nome = nome;
        this.apelido = apelido;
        this.caterioga = caterioga;
        this.urlImagem = urlImagem;
        this.descrição = descrição;
    }

    public Personagem(Long id, String nome, String apelido, CategoriaPersonagem caterioga, String urlImagem, String descrição) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.caterioga = caterioga;
        this.urlImagem = urlImagem;
        this.descrição = descrição;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public CategoriaPersonagem getCaterioga() {
        return caterioga;
    }

    public void setCaterioga(CategoriaPersonagem caterioga) {
        this.caterioga = caterioga;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
}






