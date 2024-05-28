package br.com.th4mz0.biblioteca.repository;

import br.com.th4mz0.biblioteca.enus.Languages;
import br.com.th4mz0.biblioteca.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {


    List<Book> findByLanguages(Languages lg);
}
