package com.alura.screenmatch.principal;

import com.alura.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.alura.screenmatch.modelos.Titulo;
import com.alura.screenmatch.modelos.TituloOmdb;
import com.alura.screenmatch.servicio.ApiService;
import com.alura.screenmatch.utils.JsonUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        ApiService apiService = new ApiService();
        JsonUtil jsonUtil = new JsonUtil();

        while (true) {
            System.out.println("Escriba el nombre de una pelicula o -salir-, para terminar: ");
            String busqueda = lectura.nextLine();

            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }

            try {
                Titulo miTitulo = apiService.buscarTitulo(busqueda);
                if (miTitulo != null) {
                    titulos.add(miTitulo);
                    System.out.println("Título ya convertido: " + miTitulo);
                }
            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMessage());
            }
        }

        jsonUtil.escribirJson(titulos, "titulos.json");
        System.out.println("Finalizó la ejecución del programa!");
    }
}
