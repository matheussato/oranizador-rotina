package br.com.fiap.organizadortarefas.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TarefaInesperada {

    private Long id;
    private String titulo;
    private LocalDateTime conclusao;
    private int tempoConclusao;
    
    public TarefaInesperada() {
    }

    public TarefaInesperada(Long id, String titulo, LocalDateTime conclusao, int tempoConclusao) {
        this.id = id;
        this.titulo = titulo;
        this.conclusao = conclusao;
        this.tempoConclusao = tempoConclusao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getConclusao() {
        return conclusao;
    }

    public void setConclusao(LocalDateTime conclusao) {
        this.conclusao = conclusao;
    }

    public int getTempoConclusao() {
        return tempoConclusao;
    }

    public void setTempoConclusao(int tempoConclusao) {
        this.tempoConclusao = tempoConclusao;
    }

    @Override
    public String toString() {
        return "TarefaInesperada [id=" + id + ", titulo=" + titulo + ", conclusao=" + conclusao + ", tempoConclusao="
                + tempoConclusao + "]";
    }

    

    

    
    
}
