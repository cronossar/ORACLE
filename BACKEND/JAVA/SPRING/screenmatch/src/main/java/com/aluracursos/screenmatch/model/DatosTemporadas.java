package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)


public record DatosTemporadas(
        @JsonAlias("Seasons") Integer numero,
        @JsonAlias("Episodes") List<DatosEpisodio> episodios
) {
}