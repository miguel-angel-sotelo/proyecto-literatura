package com.aluracursos.literaturachallenge;

import com.aluracursos.literaturachallenge.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturachallengeApplication implements CommandLineRunner {

	@Autowired
	private Principal principal; // Inyección de la clase Principal

	public static void main(String[] args) {
		SpringApplication.run(LiteraturachallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		 Llamada al método muestraElMenu de Principal
		principal.muestraElMenu();
	}
}

