package br.com.estudos.multimodulo.service;

import br.com.estudos.multimodulo.dto.ServiceRequestDTO;
import br.com.estudos.multimodulo.dto.ServiceResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static br.com.estudos.multimodulo.exception.ErrorConstants.*;
import static org.springframework.http.HttpStatus.*;

@Service
@AllArgsConstructor
public class UserService {
    //TODO service regra de negocios, validaçoes

    final UserFacadeImpl userFacade;

    public List<ServiceResponseDTO> findAll() {
        return Optional.of(
                        userFacade.findAll())
                .orElseThrow(() -> new ResponseStatusException(NO_CONTENT, BASE_DE_DADOS_VAZIA));
    }

    public List<ServiceResponseDTO> findById(Long id) {
        return Optional.of(
                        userFacade.findById(id))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, USUARIO_NAO_ENCONTRADO));
    }

    public ServiceResponseDTO save(ServiceRequestDTO requestDTO) {
        return Optional.of(
                        userFacade.save(requestDTO))
                .orElseThrow(() -> new ResponseStatusException(SERVICE_UNAVAILABLE, SERVIDOR_INDISPONIVEL));
    }

    public ServiceResponseDTO update(Long id, ServiceRequestDTO requestDTO) {
        return Optional.of(
                        userFacade.update(id, requestDTO))
                .orElseThrow(() -> new ResponseStatusException(SERVICE_UNAVAILABLE, SERVIDOR_INDISPONIVEL));
    }

    public void deleteById(Long id) {
        userFacade.deleteById(id);
    }
}
