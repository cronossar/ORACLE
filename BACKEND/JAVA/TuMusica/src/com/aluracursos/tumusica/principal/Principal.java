package com.aluracursos.tumusica.principal;

import com.aluracursos.tumusica.modelos.Cancion;
import com.aluracursos.tumusica.modelos.MisFavoritos;
import com.aluracursos.tumusica.modelos.Podcast;

public class Principal {
    public static void main(String[] args) {
        Cancion miCancion = new Cancion();
        miCancion.setTitulo("Forever");
        miCancion.setCantante("Kiss");

        Podcast miPodcast = new Podcast();
        miPodcast.setPresentador("Gabriela Aguiar");
        miPodcast.setTitulo("Cafe-Tech");
        //Canciones
        for (int i = 0; i < 100; i++) {
            miCancion.meGusta();
        }
        for (int i = 0; i < 2000; i++) {
            miCancion.reproduce();
        }
        //Podcast
        for (int i = 0; i < 100; i++) {
            miPodcast.meGusta();
        }
        for (int i = 0; i < 8000; i++) {
            miPodcast.reproduce();
        }

        System.out.println("Total de reproducciones " + miCancion.getTotalDeReproducciones());
        System.out.println("Total de Me Gusta " + miCancion.getTotalDeMeGusta());

        MisFavoritos favoritos = new MisFavoritos();
        favoritos.agrega(miPodcast);
        favoritos.agrega(miCancion);
    }

}
