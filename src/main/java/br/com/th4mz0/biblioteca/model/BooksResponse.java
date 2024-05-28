package br.com.th4mz0.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BooksResponse(
        @JsonProperty("results") ArrayList<BookRec> results
) {
}