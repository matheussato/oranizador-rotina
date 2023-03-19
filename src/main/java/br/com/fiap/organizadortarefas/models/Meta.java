package br.com.fiap.organizadortarefas.models;

import java.time.LocalDate;

public class Meta {
    
    private Long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private String descricao;


    public Meta(Long id,String nome, LocalDate dataInicio, LocalDate dataFinal, String descricao) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.descricao = descricao;
        this.nome = nome;
    }

    public Meta() {
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    

    @Override
    public String toString() {
        return "Meta [id=" + id + ", nome=" + nome + ", dataInicio=" + dataInicio + ", dataFinal=" + dataFinal
                + ", descricao=" + descricao + "]";
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
    

    

    

























    
}
