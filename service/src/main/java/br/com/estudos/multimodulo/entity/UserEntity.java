package br.com.estudos.multimodulo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Usuario")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", example = "1")
//    @NotNull
//    @NotBlank
//    @Positive
    private Long id;
    @ApiModelProperty(value = "name", example = "Matheus")
//    @NotBlank
//    @NotNull
    private String name;
    @ApiModelProperty(value = "cpf", example = "123.456.789-00")
//    @NotBlank
//    @NotNull
//    @Size(min = 11, max = 14)
    private String cpf;
    @ApiModelProperty(value = "email", example = "example@example.com")
//    @NotBlank
//    @NotNull
//    @Email
    private String email;
    @ApiModelProperty(value = "password", example = "123456789")
//    @NotBlank
//    @NotNull
    private String password;

}
