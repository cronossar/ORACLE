package com.alura.screenmatch.servicio;

import com.alura.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.alura.screenmatch.modelos.Titulo;
import com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.FieldNamingPolicy;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    private final Gson gson;
    private final HttpClient client;

    public ApiService() {
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        this.client = HttpClient.newHttpClient();
    }

    public Titulo buscarTitulo(String busqueda) throws ErrorEnConversionDeDuracionException {
        String direccion = "https://www.omdbapi.com/?t=" + busqueda.replace(" ", "+") + "&apikey=d4d0bf92";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            return new Titulo(miTituloOmdb);
        } catch (Exception e) {
            throw new ErrorEnConversionDeDuracionException("Error al buscar el título: " + e.getMessage());
        }
    }
}

