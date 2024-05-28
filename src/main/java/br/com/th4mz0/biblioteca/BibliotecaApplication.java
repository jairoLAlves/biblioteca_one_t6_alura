package br.com.th4mz0.biblioteca;

import br.com.th4mz0.biblioteca.principal.Principal;
import br.com.th4mz0.biblioteca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication implements ApplicationRunner {
	@Autowired
	private BookService service;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Principal menu = new Principal(service);

		menu.exibeMenu();
	}
}
