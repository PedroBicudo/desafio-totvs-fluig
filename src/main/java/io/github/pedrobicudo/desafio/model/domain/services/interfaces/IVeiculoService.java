package io.github.pedrobicudo.desafio.model.domain.services.interfaces;

import io.github.pedrobicudo.desafio.rest.dto.VeiculoCadastroDTO;

public interface IVeiculoService {

    void cadastrarVeiculo(VeiculoCadastroDTO veiculoCadastroDTO);
}
