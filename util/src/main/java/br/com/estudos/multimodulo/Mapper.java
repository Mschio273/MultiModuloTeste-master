package br.com.estudos.multimodulo;

import br.com.estudos.multimodulo.dto.ControllerRequestDTO;
import br.com.estudos.multimodulo.dto.ControllerResponseDTO;
import br.com.estudos.multimodulo.dto.ServiceRequestDTO;
import br.com.estudos.multimodulo.dto.ServiceResponseDTO;
import br.com.estudos.multimodulo.model.User;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

import static br.com.estudos.multimodulo.exception.ErrorConstants.DADOS_INVALIDOS;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class Mapper {

    private Mapper() {}

    public static final Function<ControllerRequestDTO, ServiceRequestDTO> toServiceRequestDTO =
            requestUser -> Optional.ofNullable(ServiceRequestDTO.builder()
                    .name(requestUser.getName())
                    .cpf(requestUser.getCpf())
                    .login(requestUser.getEmail())
                    .password(requestUser.getPassword())
                    .build())
                    .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, DADOS_INVALIDOS));

    public static final Function<ServiceResponseDTO, ControllerResponseDTO> toControllerResponseUserDTO =
            responseUser -> Optional.ofNullable(ControllerResponseDTO.builder()
                            .id(responseUser.getId())
                            .name(responseUser.getName())
                            .cpf(responseUser.getCpf())
                            .build())
                    .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, DADOS_INVALIDOS));

    public static final Function<ServiceRequestDTO, User> toUserSave =
            request -> Optional.ofNullable(User.builder()
                            .name(request.getName())
                            .cpf(request.getCpf())
                            .login(request.getLogin())
                            .password(request.getPassword())
                            .build())
                    .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, DADOS_INVALIDOS));

    public static final Function<User, ServiceResponseDTO> toServiceResponseDTO =
            user -> Optional.ofNullable(ServiceResponseDTO.builder()
                            .id(user.getId())
                            .name(user.getName())
                            .cpf(user.getCpf())
                            .build())
                    .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, DADOS_INVALIDOS));

    public static final BiFunction<Long, ServiceRequestDTO, User> toUserUpdate =
            (id, request) -> Optional.ofNullable(User.builder()
                            .id(id)
                            .name(request.getName())
                            .login(request.getLogin())
                            .password(request.getPassword())
                            .cpf(request.getCpf())
                            .build())
                    .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST, DADOS_INVALIDOS));
}

