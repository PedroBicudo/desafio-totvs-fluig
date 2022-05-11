package io.github.pedrobicudo.desafio.model.domain.services.implementations;

import io.github.pedrobicudo.desafio.model.domain.entities.Veiculo;
import io.github.pedrobicudo.desafio.model.domain.repositories.VeiculoRepository;
import io.github.pedrobicudo.desafio.model.domain.services.interfaces.IVeiculoService;
import io.github.pedrobicudo.desafio.rest.dto.VeiculoCadastroDTO;
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
public class VeiculoService implements IVeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public void cadastrarVeiculo(VeiculoCadastroDTO veiculoCadastroDTO) {
        Veiculo veiculo = new Veiculo(
                veiculoCadastroDTO.getNome(),
                veiculoCadastroDTO.getMarca(),
                veiculoCadastroDTO.getModelo(),
                veiculoCadastroDTO.getDataFabricacao(),
                veiculoCadastroDTO.getConsumoMedioCidadeKML(),
                veiculoCadastroDTO.getConsumoMedioRodoviaKML()
        );

        veiculoRepository.save(veiculo);

    }

}
