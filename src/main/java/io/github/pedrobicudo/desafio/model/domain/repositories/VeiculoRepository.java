package io.github.pedrobicudo.desafio.model.domain.repositories;

import io.github.pedrobicudo.desafio.model.domain.entities.Veiculo;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VeiculoRepository {

    @Getter
    private List<Veiculo> veiculos = new ArrayList<>();

    public void save(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

}
