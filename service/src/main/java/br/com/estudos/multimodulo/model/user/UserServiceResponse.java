package br.com.estudos.multimodulo.model.user;

import br.com.estudos.multimodulo.entity.CepEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserServiceResponse {

    private Long id;
    private String name;
    private String cpf;
    private CepEntity endereco;
}
