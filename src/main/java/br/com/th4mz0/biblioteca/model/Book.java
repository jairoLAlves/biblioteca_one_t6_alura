package br.com.th4mz0.biblioteca.model;

import br.com.th4mz0.biblioteca.enus.Languages;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private Integer downloadCount;

    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @Enumerated(EnumType.STRING)
    private Languages languages;

    public Book() {
    }
    public Book(BookRec book) {
        this.title = book.title();
        this.authors = book.authors().stream().map(Author::new).toList();
        this.downloadCount = book.download_count();
        this.languages = Languages.fromAbreviacao(book.languages().get(0));

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Languages getLanguages() {
        return languages;
    }

    public void setLanguages(Languages languages) {
        this.languages = languages;
    }

    @Override
    public String toString(){
        return   String.format("""
                ----- LIVRO -----
                Título: %s
                Autores: %s
                Idioma: %s
                Número de dowloads: %d
                -----------------
                """, this.title, this.authors, this.languages, this.downloadCount);
    }
}
