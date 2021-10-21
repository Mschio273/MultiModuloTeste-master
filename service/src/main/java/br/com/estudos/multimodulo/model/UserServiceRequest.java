package br.com.estudos.multimodulo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserServiceRequest {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private String cep;
}