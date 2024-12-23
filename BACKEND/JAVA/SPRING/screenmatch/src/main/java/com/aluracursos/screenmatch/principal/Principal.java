package com.aluracursos.screenmatch.principal;

import ch.qos.logback.core.encoder.JsonEscapeUtil;
import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=fa0fa535";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraElMenu(){
        System.out.println("Escribe el nombre de la série que deseas buscar");

        //Busca los datos generales de las series
        var nombreSerie = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        //https://www.omdbapi.com/?t=game+of+thrones&apikey=4fc7c187
        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);
        System.out.println("**************************************");

        //Busca los datos de todas las temporadas
        System.out.println("LISTA DE TEMPORADAS");

        List<DatosTemporadas> temporadas = new ArrayList<>();

        for (int i = 1; i <= datos.totalTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            DatosTemporadas datosTemporada = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporada);
        }
        temporadas.forEach(System.out::println);
        System.out.println("**************************************");

        //Mostrar solo el titulo de los episodios para las temporadas
        for (int i = 0; i < datos.totalTemporadas(); i++) {
            List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();
            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo());
            }
        }
        // Mejoría usando funciones Lambda
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
        System.out.println("**************************************");

        //Convertir todas las informaciones en DatosEpisodio

        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());


        //Top 5 episodios
        System.out.println("Top 5 Episodios");
        datosEpisodios.stream()
                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
                //.peek(e -> System.out.println("Primer Filtro N/A" + e) )
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                //.peek(e -> System.out.println("Segundo Filtro Ordenacion M>M" + e) )
                //.map(e -> e.titulo().toUpperCase())
                //.peek(e -> System.out.println("Tercer Filtro Mayusculas (m/M)" + e) )
                .limit(5)
                .forEach(System.out::println);


        System.out.println("**************************************");

        //Convirtiendo los Datos en una lista de tipo Episodio

        temporadas.forEach(t -> {
            System.out.println("Temporada " + t.numero() + ": " + t.episodios());
        });

        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                    .map(d -> new Episodio(t.numero(),d)))
                .collect(Collectors.toList());

        episodios.forEach(System.out::println);

        System.out.println("**************************************");

        //Busqueda/Filtrar episodios por año (fechas)

        System.out.println("Indicanos el año que te interesa busquemos el episodio");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        episodios.stream()
                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> System.out.println(
                        "Temporada " + e.getTemporada() +
                                " Episodio " + e.getTitulo() +
                                " Fecha de Lanzamiento " + e.getFechaDeLanzamiento().format(dtf)

                 ));

        System.out.println("**************************************");

        //Busqueda en la coleccion por el titulo
        /*System.out.println("Escribe alguna palabra que forme parte del titulo del episodio a buscar");
        var pedazoTitulo = teclado.nextLine();
        Optional<Episodio> episodioBuscado = episodios.stream()
                .filter(e -> e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
                .findFirst();
        if (episodioBuscado.isPresent()){
            System.out.println(" Episodio encontrado ");
            System.out.println(" Los datos son: " + episodioBuscado.get());
        }else{
            System.out.println(" Episodio no encontrado ");
        }*/

        //Crear Mapa de datos por temporada
        Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));
        System.out.println("Evaluaciones por temporada");
        System.out.println(evaluacionesPorTemporada);
        System.out.println("*****************************");
        DoubleSummaryStatistics est = episodios.stream()
                .filter(e -> e.getEvaluacion() > 0.0)
                .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));
        System.out.println("Media de las evaluaciones =" + est.getAverage());
        System.out.println("Episodio mejor evaluado =" + est.getMax());
        System.out.println("Episodio peor evaluado =" + est.getMin());

        System.out.println("*****************************");

    }
}
