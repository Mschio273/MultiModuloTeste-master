package br.com.estudos.multimodulo.model;

import br.com.estudos.multimodulo.entity.Cep;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserControllerResponse {

    private Long id;
    private String name;
    private String cpf;
    private Cep endereco;
}