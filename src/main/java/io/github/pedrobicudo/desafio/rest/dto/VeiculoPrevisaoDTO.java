package io.github.pedrobicudo.desafio.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VeiculoPrevisaoDTO {
    private String nome;
    private String marca;
    private String modelo;
    private Integer ano;
    private Double litrosDeCombustivelGastos;
    private BigDecimal precoTotalGastoComCombustivel;
}
