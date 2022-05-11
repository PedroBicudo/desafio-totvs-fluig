package io.github.pedrobicudo.desafio.model.domain.services.interfaces;

import io.github.pedrobicudo.desafio.rest.dto.VeiculoPrevisaoDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IPrevisaoService {
    List<VeiculoPrevisaoDTO> obterDeRankVeiculosDaPrevisaoDeGastos(BigDecimal precoGasolina, Double totalKmCidade, Double totalKmRodovia);
}
