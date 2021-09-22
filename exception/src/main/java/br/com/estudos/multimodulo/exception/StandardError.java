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
    private final String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
    private final int status;
    private final String message;
}
