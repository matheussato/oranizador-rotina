package br.com.fiap.organizadortarefas.models;

import java.time.LocalDateTime;

public class Rotina {

    private Long id;
    private LocalDateTime acordar;
    private LocalDateTime dormir;
    private LocalDateTime almocar;
    private LocalDateTime jantar;
    private LocalDateTime academia;
    private LocalDateTime estudar;
    private LocalDateTime faculdade;
    private LocalDateTime extras;


    

    public Rotina(Long id, LocalDateTime acordar, LocalDateTime dormir, LocalDateTime almocar, LocalDateTime jantar,
            LocalDateTime academia, LocalDateTime estudar, LocalDateTime faculdade, LocalDateTime extras) {
        this.id = id;
        this.acordar = acordar;
        this.dormir = dormir;
        this.almocar = almocar;
        this.jantar = jantar;
        this.academia = academia;
        this.estudar = estudar;
        this.faculdade = faculdade;
        this.extras = extras;
    }

    public Rotina() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getAcordar() {
        return acordar;
    }

    public void setAcordar(LocalDateTime acordar) {
        this.acordar = acordar;
    }

    public LocalDateTime getDormir() {
        return dormir;
    }

    public void setDormir(LocalDateTime dormir) {
        this.dormir = dormir;
    }

    public LocalDateTime getAlmocar() {
        return almocar;
    }

    public void setAlmocar(LocalDateTime almocar) {
        this.almocar = almocar;
    }

    public LocalDateTime getJantar() {
        return jantar;
    }

    public void setJantar(LocalDateTime jantar) {
        this.jantar = jantar;
    }

    public LocalDateTime getAcademia() {
        return academia;
    }

    public void setAcademia(LocalDateTime academia) {
        this.academia = academia;
    }

    public LocalDateTime getEstudar() {
        return estudar;
    }

    public void setEstudar(LocalDateTime estudar) {
        this.estudar = estudar;
    }

    public LocalDateTime getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(LocalDateTime faculdade) {
        this.faculdade = faculdade;
    }

    public LocalDateTime getExtras() {
        return extras;
    }

    public void setExtras(LocalDateTime extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "Rotina [id=" + id + ", acordar=" + acordar + ", dormir=" + dormir + ", almocar=" + almocar + ", jantar="
                + jantar + ", academia=" + academia + ", estudar=" + estudar + ", faculdade=" + faculdade + ", extras="
                + extras + "]";
    }
    
    
    
    
}
