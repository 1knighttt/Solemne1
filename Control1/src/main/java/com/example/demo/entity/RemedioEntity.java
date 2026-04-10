package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "remedio") // Requisito: la base de datos debe llamarse remedio 
public class RemedioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // [cite: 15]

    private String nombreCientifico; // [cite: 16]
    private String marca; // [cite: 17]
    private Double gramos; // [cite: 18]
    private int anio; // [cite: 19]
    private char tipo; // 'M'arca, 'B'ioequivalente, 'G'enerico [cite: 20]
    private boolean controlado; // [cite: 20]

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