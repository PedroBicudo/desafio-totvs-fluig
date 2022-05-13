package io.github.pedrobicudo.desafio;

import io.github.pedrobicudo.desafio.model.domain.services.interfaces.IVeiculoService;
import io.github.pedrobicudo.desafio.rest.dto.VeiculoCadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
public class DesafioApplication {

	@Autowired
	private IVeiculoService veiculoService;

	@Bean
	public CommandLineRunner init() {
		return args -> {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			VeiculoCadastroDTO[] veiculos = new VeiculoCadastroDTO[]{
					new VeiculoCadastroDTO("Renault Kwid", "Renault", "Kwid", sdf.parse("2017-12-12"), 13.6, 14.2),
					new VeiculoCadastroDTO("Chevrolet Onix", "Chevrolet", "Onix", sdf.parse("2022-12-12"), 13.9, 16.7),
					new VeiculoCadastroDTO("Fiat Argo", "Fiat", "Argo", sdf.parse("2017-12-12"), 13.7, 14.7),
					new VeiculoCadastroDTO("Fiat Mobi", "Fiat", "Mobi", sdf.parse("2016-12-12"), 13.7, 15.3),
					new VeiculoCadastroDTO("Honda City", "Honda", "City", sdf.parse("2022-12-12"), 12.4, 14.6)
			};

			List.of(veiculos).forEach(veiculoService::cadastrarVeiculo);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

}
