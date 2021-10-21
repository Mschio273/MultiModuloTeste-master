package br.com.estudos.multimodulo.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
public class StandardError {
    @ApiModelProperty(value = "tempo do erro", example = "2021")
    private final String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    @ApiModelProperty(value = "status do erro", example = "NOT_FOUND")
    private final int status;
    @ApiModelProperty(value = "mensagem do erro", example = "Id não existe")
    private final String message;
}
