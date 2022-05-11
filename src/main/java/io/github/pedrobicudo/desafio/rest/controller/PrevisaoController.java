package io.github.pedrobicudo.desafio.rest.controller;

import io.github.pedrobicudo.desafio.model.domain.services.interfaces.IPrevisaoService;
import io.github.pedrobicudo.desafio.rest.dto.VeiculoPrevisaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/previsao-gastos/rank")
@Validated
public class PrevisaoController {

    @Autowired
    private IPrevisaoService previsaoService;

    @CrossOrigin(methods = {RequestMethod.GET})
    @GetMapping
    public List<VeiculoPrevisaoDTO> obterORankDeVeiculosPorPreco(
            @RequestParam @Positive(message = "O preco da gasolina deve ser maior que 0") BigDecimal precoGasolina,
            @RequestParam @Positive(message = "O total de kilômetros percorridos na cidade deve ser maior que 0") Double totalKmCidade,
            @RequestParam @Positive(message = "O total de kilômetros percorridos na rodovia deve ser maior que 0") Double totalKmRodovia
    ) {
        return previsaoService.obterDeRankVeiculosDaPrevisaoDeGastos(precoGasolina, totalKmCidade, totalKmRodovia);
    }

}
