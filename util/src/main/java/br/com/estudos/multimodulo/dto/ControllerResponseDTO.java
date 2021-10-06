package br.com.estudos.multimodulo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ControllerResponseDTO {

    @ApiModelProperty(value = "id", example = "1")
    @NotBlank
    @NotNull
    @Positive
    private Long id;
    @ApiModelProperty(value = "name", example = "Matheus")
    @NotBlank
    @NotNull
    private String name;
    @ApiModelProperty(value = "cpf", example = "123.456.789-00")
    @NotBlank
    @NotNull
    @Size(min = 11, max = 14)
    private String cpf;
}
