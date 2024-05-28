package br.com.th4mz0.biblioteca.principal;

import br.com.th4mz0.biblioteca.enus.Languages;
import br.com.th4mz0.biblioteca.model.Author;
import br.com.th4mz0.biblioteca.model.Book;
import br.com.th4mz0.biblioteca.model.BookRec;
import br.com.th4mz0.biblioteca.model.BooksResponse;
import br.com.th4mz0.biblioteca.repository.BookRepository;
import br.com.th4mz0.biblioteca.service.BookService;
import br.com.th4mz0.biblioteca.service.ConsumoAPI;
import br.com.th4mz0.biblioteca.service.ConverterDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private final Scanner scanner = new Scanner(System.in);
    private final String ENDERECO ="https://gutendex.com/books?search=";
    private  ConsumoAPI api = new ConsumoAPI();
    private ConverterDados converterDados  = new ConverterDados();
    private BookService service;

    public Principal(BookService service){
        this.service = service;

    }


    public void exibeMenu() {

        var opcao = -1;

        while (opcao != 0) {

            var menu = """
                    Escolha o número da sua opção:
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    0 - sair

                    """;
            System.out.println(menu);
            opcao = scanner.nextInt();

            scanner.nextLine();
            switch (opcao) {
                case 1:
                    buscarLivroPeloTitulo();
                    break;
                case 2:
                    listarLivrosRegistrados();
                    break;
                case 3:
                    listarTodosOsAutores();
                    break;
                case 4:
                    listarAutoresVivosPorAno();
                    break;
                case 5:
                    listarLivrosPorUmIdioma();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");


            }


        }
    }

    private void listarLivrosPorUmIdioma() {
        System.out.println("""
                es - Espanhol
                en - Inglês
                fr - Francês
                pt - Português
                """);
        var idioma = scanner.nextLine();

        Languages lg = null;
        try {
            lg =  Languages.fromAbreviacao(idioma);
            List<Book> books = service.getBooksLanguages(lg);
            books.forEach(System.out::println);

        }catch (IllegalArgumentException e){
            System.out.println("Não existe livros nesse idioma no banco de dados.");

        }



    }

    private void listarAutoresVivosPorAno() {
        System.out.println("Insira o ano que deseja pesquisar?");
        int ano =scanner.nextInt();
        scanner.nextLine();

        List<Author> authors = service.listarAutoresVivosPorAno(ano);
        if (!authors.isEmpty()){
            authors.forEach(System.out::println);
        }else{
            System.out.println("Nenhum autor encontrado!");
        }
    }

    private void listarTodosOsAutores() {
        List<Author> authors = service.listarTodosOsAutores();
        if(!authors.isEmpty()){
            authors.forEach(System.out::println);
        }else {
            System.out.println("Você não tem autores cadastrados");
        }

    }

    private void listarLivrosRegistrados() {
        List<Book> books =  service.getAllBook();
        if(!books.isEmpty()){
            books.forEach(System.out::println);
        }else {
            System.out.println("Você não tem livros cadastrados");
        }

    }

    private void buscarLivroPeloTitulo() {
        System.out.println("Insira o nome do livro que você deseja procurar");

        var nomeLivro = scanner.nextLine();

       String result =  api.obterDados(ENDERECO+formatSearch(nomeLivro));

        BooksResponse booksResponse = converterDados.obterDados(result, BooksResponse.class);
        Optional<BookRec> opBookRec = booksResponse.results().stream().findFirst();

       if(opBookRec.isPresent()){
         Book book = new Book(opBookRec.get());
         System.out.println(book);
         service.salveBook(book);

       }else {
           System.out.println("Livro não encontrado!");
       }


    }



    private String formatSearch(String nomes){
        return nomes.replace(" ", "+");
    }
}

