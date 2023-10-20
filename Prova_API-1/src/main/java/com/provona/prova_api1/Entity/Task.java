package com.provona.prova_api1.Entity;

public class Task {
    private Long codigo;
    private String nome;
    private String descricao;

    private String status;

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome;
    }
    public String getDescricao() {
            return descricao;
    }

    public void setDescricao(String descricao) {
            this.descricao = descricao;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

 }

