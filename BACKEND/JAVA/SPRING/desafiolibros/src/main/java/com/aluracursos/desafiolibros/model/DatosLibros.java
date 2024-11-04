package com.aluracursos.desafiolibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosLibros(

        @JsonAlias("title") String titulo,

        @JsonAlias("authors") List<DatosAutor> autor,

        @JsonAlias("languajes") List<String> idiomas,

        @JsonAlias("download_count") Double numeroDeDescargas
) {
}
