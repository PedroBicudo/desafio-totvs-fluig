package io.github.pedrobicudo.desafio.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VeiculoCadastroDTO {

    @NotEmpty(message = "O nome do veículo deve ser informado")
    private String nome;

    @NotEmpty(message = "A marca do veículo deve ser informada")
    private String marca;

    @NotEmpty(message = "O modelo do veículo deve ser informado")
    private String modelo;

    @NotNull(message = "A data de fabricação do veículo deve ser informada")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFabricacao;

    @NotNull(message = "O consumo médio (Km/L) do veículo em cidade deve ser informado")
    @Positive(message = "O consumo médio (Km/L) do veículo em cidade deve ser maior que 0")
    private Double consumoMedioCidadeKML;

    @NotNull(message = "O consumo médio (Km/L) do veículo em rodovia deve ser informado")
    @Positive(message = "O consumo médio (Km/L) do veículo em rodovia deve ser maior que 0")
    private Double consumoMedioRodoviaKML;

}
