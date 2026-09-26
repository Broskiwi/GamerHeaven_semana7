package com.duoc.gamerheaven.model;

import jakarta.persistence.*;

@Entity
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String titulo;
    @Column(nullable = false)
    private int precio;
    @Column(nullable = false)
    private String plataforma;
    @Column(nullable = false)
    private boolean disponibilidad;

    public Videojuego() {
    }

    public Videojuego(String titulo, int precio, String plataforma, boolean disponibilidad) {
        this.titulo = titulo;
        this.precio = precio;
        this.plataforma = plataforma;
        this.disponibilidad = disponibilidad;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
