package br.com.th4mz0.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookRec(
        @JsonProperty("id")
        int id,
        @JsonProperty("title")
        String title,
        @JsonProperty("authors")
        ArrayList<AuthorRec> authors,
        @JsonProperty("languages")
                ArrayList<String> languages,

        @JsonProperty("download_count")
        int download_count
) {
}
