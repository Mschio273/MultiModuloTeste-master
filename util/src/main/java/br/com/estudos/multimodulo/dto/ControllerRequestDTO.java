package br.com.estudos.multimodulo.dto;

import io.swagger.annotations.ApiModelProperty;
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
// TODO Anotaçoes swagger

    @ApiModelProperty(value = "name", example = "Matheus")
    @NotBlank
    @NotNull
    private String name;
    @ApiModelProperty(value = "cpf", example = "123.456.789-00")
    @NotBlank
    @NotNull
    @Size(min = 11, max = 14)
    private String cpf;
    @ApiModelProperty(value = "email", example = "example@example.com")
    @NotBlank
    @NotNull
    @Email
    private String email;
    @ApiModelProperty(value = "password", example = "123456789")
    @NotBlank
    @NotNull
    private String password;
}
