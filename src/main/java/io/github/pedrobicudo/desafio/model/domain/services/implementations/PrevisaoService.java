package io.github.pedrobicudo.desafio.model.domain.services.implementations;

import io.github.pedrobicudo.desafio.model.domain.repositories.VeiculoRepository;
import io.github.pedrobicudo.desafio.model.domain.services.interfaces.IPrevisaoService;
import io.github.pedrobicudo.desafio.rest.dto.VeiculoPrevisaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrevisaoService implements IPrevisaoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public List<VeiculoPrevisaoDTO> obterDeRankVeiculosDaPrevisaoDeGastos(
            BigDecimal precoGasolina,
            Double totalKmCidade,
            Double totalKmRodovia
    ) {
        return veiculoRepository.getVeiculos()
                .stream()
                .map(v -> {
                    double litrosCidade = totalKmCidade / v.getConsumoMedioCidadeKML();
                    double litrosRodovia = totalKmRodovia / v.getConsumoMedioRodoviaKML();

                    BigDecimal litrosTotalGasolina = new BigDecimal(litrosCidade + litrosRodovia)
                            .setScale(2, RoundingMode.HALF_DOWN);

                    BigDecimal precoTotalGasolina = precoGasolina
                            .multiply(litrosTotalGasolina)
                            .setScale(2, RoundingMode.HALF_DOWN);

                    Calendar cal = Calendar.getInstance();
                    cal.setTime(v.getDataFabricacao());

                    return new VeiculoPrevisaoDTO(
                            v.getNome(),
                            v.getMarca(),
                            v.getModelo(),
                            cal.get(Calendar.YEAR),
                            litrosTotalGasolina.doubleValue(),
                            precoTotalGasolina
                    );
                })
                .sorted(Comparator.comparing(VeiculoPrevisaoDTO::getPrecoTotalGastoComCombustivel))
                .collect(Collectors.toList());
    }

}
