package com.seduc2.gta6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "missoes")
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String protagonista;
    private Double recompensa;
    private Boolean concluida = false;

    public Missao() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getProtagonista() { return protagonista; }
    public void setProtagonista(String protagonista) { this.protagonista = protagonista; }

    public Double getRecompensa() { return recompensa; }
    public void setRecompensa(Double recompensa) { this.recompensa = recompensa; }

    public Boolean getConcluida() { return concluida; }
    public void setConcluida(Boolean concluida) { this.concluida = concluida; }
}