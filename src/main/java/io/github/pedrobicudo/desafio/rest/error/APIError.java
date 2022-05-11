package io.github.pedrobicudo.desafio.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class APIError {
    private String code;
    private List<String> message;

    public APIError(String code, String message) {
        this.code = code;
        this.message = List.of(message);
    }
}
