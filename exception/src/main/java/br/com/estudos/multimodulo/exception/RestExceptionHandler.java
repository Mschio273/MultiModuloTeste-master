package br.com.estudos.multimodulo.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    // TODO UnsupportedTemporalTypeException

//    @ExceptionHandler(NotFoundException.class)
//    public StandardError handleResponseStatusException(ResponseStatusException e) {
//        return StandardError.builder()
//                        .status(e.getRawStatusCode())
//                        .message(e.getMessage())
//                        .build();
//    }
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    @ResponseStatus(BAD_REQUEST)
//    public StandardError handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
//        return StandardError.builder()
//                .status(BAD_REQUEST.value())
//                .message(NECESSARIO_USER_PARA_SALVAR)
//                .build();
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(INTERNAL_SERVER_ERROR)
//    public StandardError handleGeneralExceptions(Exception e) {
//        return StandardError.builder()
//                .status(INTERNAL_SERVER_ERROR.value())
//                .message(e.getMessage())
//                .build();
//    }
//
//
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(INTERNAL_SERVER_ERROR)
//    public StandardError handleRuntimeExceptions(RuntimeException e) {
//        return StandardError.builder()
//                .status(INTERNAL_SERVER_ERROR.value())
//                .message(ERRO_INESPERADO)
//                .build();
//    }
//
//    @ExceptionHandler(IOException.class)
//    @ResponseStatus(INTERNAL_SERVER_ERROR)
//    public StandardError handleIoExceptionExceptions(IOException e) {
//        return StandardError.builder()
//                .status(INTERNAL_SERVER_ERROR.value())
//                .message(ERRO_DE_ENTRADA_SAIDA)
//                .build();
//    }
//
//    @ExceptionHandler(UnsupportedTemporalTypeException.class)
//    @ResponseStatus(BAD_REQUEST)
//    public StandardError handleUnsupportedTemporalTypeException(UnsupportedTemporalTypeException e) {
//        return StandardError.builder()
//                .status(BAD_REQUEST.value())
//                .message(NECESSARIO_USER_PARA_SALVAR)
//                .build();
//    }
}