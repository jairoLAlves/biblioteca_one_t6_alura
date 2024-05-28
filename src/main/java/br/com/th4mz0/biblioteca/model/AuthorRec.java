package br.com.th4mz0.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public record AuthorRec(
    //@JsonProperty("name")
    String name,
   // @JsonProperty("birth_year")
    int birth_year,
   // @JsonProperty("death_year")
    int death_year){
}
