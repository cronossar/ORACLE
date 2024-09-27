package com.alura.screenmatch.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonUtil {
    private final Gson gson;

    public JsonUtil() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting() // Agregando el formato de impresión bonito
                .create();
    }

    public void escribirJson(List<?> objetos, String nombreArchivo) {
        try (FileWriter escritura = new FileWriter(nombreArchivo)) {
            escritura.write(gson.toJson(objetos));
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
