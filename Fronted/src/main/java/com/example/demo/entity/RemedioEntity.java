package com.example.demo.entity;

public class RemedioEntity {

    private Long id; 
    private String nombreCientifico; 
    private String marca; 
    private Double gramos; 
    private int anio; 
    private char tipo; 
    private boolean controlado; 

    // Constructor vacío obligatorio para JPA 
    public RemedioEntity() {}

    // --- GETTERS Y SETTERS ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getGramos() {
        return gramos;
    }

    public void setGramos(Double gramos) {
        this.gramos = gramos;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public boolean isControlado() {
        return controlado;
    }

    public void setControlado(boolean controlado) {
        this.controlado = controlado;
    }
}