package io.github.pedrobicudo.desafio.model.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Veiculo {
    private String nome;
    private String marca;
    private String modelo;
    private Date dataFabricacao;
    private Double consumoMedioCidadeKML;
    private Double consumoMedioRodoviaKML;
}
