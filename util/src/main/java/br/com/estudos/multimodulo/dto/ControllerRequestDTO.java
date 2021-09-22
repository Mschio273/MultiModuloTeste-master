package br.com.estudos.multimodulo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ControllerRequestDTO {
// TODO @NOTBLANK MINSIZE MAXSIZE SIZE

    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    @Size(min = 11, max = 14)
    private String cpf;
    @NotBlank
    @NotNull
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String password;
}
