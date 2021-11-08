package br.com.estudos.multimodulo.model;

import br.com.estudos.multimodulo.entity.CepEntity;
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
    private CepEntity endereco;
}