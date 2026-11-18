package com.seduc2.gta6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculos")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String classe;
    private Integer velocidadeMax;
    private Double preco;

    public Veiculo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getClasse() { return classe; }
    public void setClasse(String classe) { this.classe = classe; }

    public Integer getVelocidadeMax() { return velocidadeMax; }
    public void setVelocidadeMax(Integer velocidadeMax) { this.velocidadeMax = velocidadeMax; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
}