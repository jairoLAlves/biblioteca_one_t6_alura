package br.com.th4mz0.biblioteca.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    private Integer birthYear;

    private Integer deathYear;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;


    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Author(AuthorRec autor) {
        this.name = autor.name();
        this.birthYear = autor.birth_year();
        this.deathYear = autor.death_year();
    }

    @Override
    public String toString() {
        return String.format("Nome: %s %d/%d", this.name, this.birthYear, this.deathYear);
    }
}
