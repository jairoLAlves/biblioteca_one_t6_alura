package br.com.th4mz0.biblioteca.service;

import br.com.th4mz0.biblioteca.enus.Languages;
import br.com.th4mz0.biblioteca.model.Author;
import br.com.th4mz0.biblioteca.model.Book;
import br.com.th4mz0.biblioteca.repository.AuthorRepository;
import br.com.th4mz0.biblioteca.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    AuthorRepository authRepository;


    public void salveBook(Book book){
        bookRepository.save(book);
    }
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public List<Author> listarTodosOsAutores(){
        return authRepository.findAll();
    }

    public List<Book> getBooksLanguages(Languages lg){
        System.out.println(lg.toString());
        return bookRepository.findByLanguages(lg);
    }
    public List<Author> listarAutoresVivosPorAno(Integer ano){
        return authRepository.findAuthorsAliveInYear(ano);

    }





}
