package com.aluracursos.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {

    private Integer temporada;
    //private Integer numero;
    private String titulo;
    private Integer numeroEpisodio;
    private Double evaluacion;
    private LocalDate fechaDeLanzamiento;

    public Episodio(Integer numero, DatosEpisodio d){
        this.temporada = numero;
        this.titulo = d.titulo();
        this.numeroEpisodio = d.numeroEpisodio();
        try{
            this.evaluacion = Double.valueOf(d.evaluacion());
        }catch(NumberFormatException e){
            this.evaluacion = 0.0;
        }
        try {
            this.fechaDeLanzamiento = LocalDate.parse(d.fechaDeLanzamiento());
        } catch (DateTimeParseException e) {
            // Manejar la excepción, por ejemplo, estableciendo una fecha por defecto
            this.fechaDeLanzamiento = LocalDate.now(); // o cualquier otra lógica que prefieras
        }
        //this.fechaDeLanzamiento = LocalDate.parse(d.fechaDeLanzamiento());

    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(Integer numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    @Override
    public String toString() {
        return
                "temporada=" + temporada +
                //", numero=" + numero +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", evaluacion=" + evaluacion +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento;
    }
}
