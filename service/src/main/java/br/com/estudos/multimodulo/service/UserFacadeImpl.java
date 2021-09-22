package br.com.estudos.multimodulo.service;

import br.com.estudos.multimodulo.Mapper;
import br.com.estudos.multimodulo.dto.ServiceRequestDTO;
import br.com.estudos.multimodulo.dto.ServiceResponseDTO;
import br.com.estudos.multimodulo.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.estudos.multimodulo.exception.ErrorConstants.ID_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@Component
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserRepository userRepository;

    public List<ServiceResponseDTO> findAll() {
        return userRepository.findAll().stream()
                .map(Mapper.toServiceResponseDTO)
                .collect(Collectors.toList());
    }

    public List<ServiceResponseDTO> findById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(NOT_FOUND, ID_NAO_ENCONTRADO);
        }
        return userRepository.findById(id).stream()
                .map(Mapper.toServiceResponseDTO)
                .collect(Collectors.toList());
    }

    public ServiceResponseDTO save(ServiceRequestDTO requestDTO) {
        return Mapper.toServiceResponseDTO.apply(
                userRepository.save(Mapper.toUserSave.apply(requestDTO)));
    }

    public ServiceResponseDTO update(Long id, ServiceRequestDTO requestDTO) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(NOT_FOUND, ID_NAO_ENCONTRADO);
        }
        return Mapper.toServiceResponseDTO.apply(
                userRepository.save(
                        Mapper.toUserUpdate.apply(id, requestDTO)));
    }

    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(OK);
        }
        userRepository.deleteById(id);
    }
}