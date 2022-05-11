package io.github.pedrobicudo.desafio.rest.controller;

import io.github.pedrobicudo.desafio.model.domain.services.interfaces.IVeiculoService;
import io.github.pedrobicudo.desafio.rest.dto.VeiculoCadastroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

    @Autowired
    private IVeiculoService veiculoService;

    @CrossOrigin(methods = {RequestMethod.POST})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarVeiculo(
            @RequestBody @Valid VeiculoCadastroDTO veiculoCadastroDTO
    ) {
        veiculoService.cadastrarVeiculo(veiculoCadastroDTO);
    }

}
