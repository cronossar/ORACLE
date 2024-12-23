package com.aluracursos.desafiolibros.principal;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.aluracursos.desafiolibros.model.Datos;
import com.aluracursos.desafiolibros.model.DatosLibros;
import com.aluracursos.desafiolibros.service.ConsumoAPI;
import com.aluracursos.desafiolibros.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";
    //Primero creamos una instancia de consumoAPI y ConvierteDatos
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);

    public void muestraElMenu(){
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        System.out.println("************************");
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);
        System.out.println("************************");
        //Top 10 de libros mas descargados
        System.out.println("Top 10 de Libros más descargados");
        System.out.println("--------------------------------");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibros::numeroDeDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);
        System.out.println("************************");
        //Busqueda de Libros por nombre
        System.out.println("Ingrese el nombre del Libro a buscar");
        var tituloLibro = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" " , "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                        .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                                .findFirst();
                        if (libroBuscado.isPresent()){
                            System.out.println("Libro Encontrado ");
                            System.out.println(libroBuscado.get());
                        }else{
                            System.out.println("Libro No Encontrado ");
                        }
        System.out.println("************************");

        //Trabajando con Estadísticas
        DoubleSummaryStatistics est = datos.resultados().stream()
                .filter(d -> d.numeroDeDescargas() >0 )
                .collect(Collectors.summarizingDouble(DatosLibros::numeroDeDescargas));
        System.out.println("Cantidad Media de descargas: " + est.getAverage());
        System.out.println("Cantidad Máxima de descargas: " + est.getMax());
        System.out.println("Cantidad Mínima de descargas: " + est.getMin());
        System.out.println("Cantidad de registros evaluados para calcular las estadísticas: " + est.getCount());

        System.out.println("************************");
    }
}
