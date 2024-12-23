package com.aluracursos.tumusica.modelos;

public class Audio {

    String titulo;
    private int duracion;
    private int totalDeReproducciones;
    private int totalDeMeGusta;
    private int clasificacion;

    public void meGusta(){
        this.totalDeMeGusta++;
    }

    public void reproduce(){
        this.totalDeReproducciones++;
    }
//Getters and Setters
    public void reproducir(){
        return;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getTotalDeReproducciones() {
        return totalDeReproducciones;
    }

    public void setTotalDeReproducciones(int totalDeReproducciones) {
        this.totalDeReproducciones = totalDeReproducciones;
    }

    public int getTotalDeMeGusta() {
        return totalDeMeGusta;
    }

    public void setTotalDeMeGusta(int totalDeMeGusta) {
        this.totalDeMeGusta = totalDeMeGusta;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }
}
