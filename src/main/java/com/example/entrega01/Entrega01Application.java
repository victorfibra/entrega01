package com.example.entrega01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entrega01.model.Contrato;
import com.example.entrega01.repository.ContratoRepository;

@SpringBootApplication
public class Entrega01Application {

	public static void main(String[] args) {
		SpringApplication.run(Entrega01Application.class, args);
	}

	@Bean
	CommandLineRunner init(ContratoRepository repository) {
    return args -> {
        repository.save(new Contrato(1L, "Maria Clara", "mariaclara123", 554.2));
        repository.save(new Contrato(2L, "Josimar Silva", "josimar031", 351.5));
        repository.save(new Contrato(3L, "Carlos Victor", "victor_fibra", 8.5));
    };
}

}


