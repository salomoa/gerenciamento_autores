package com.gerenciamento.autores.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_AUTOR")
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @Column(name = "nomeAutor")
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    @Column(name = "nacionalAutor")
    public String getNacionalidade() { return nacionalidade; }

    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }

    @Column(name = "nascAutor")
    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
}
