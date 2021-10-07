package br.com.estudos.multimodulo.service;

import br.com.estudos.multimodulo.dto.UserDto;
import br.com.estudos.multimodulo.dto.mappers.UserMapper;
import br.com.estudos.multimodulo.model.User;
import br.com.estudos.multimodulo.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.estudos.multimodulo.exception.ErrorConstants.*;
import static org.springframework.http.HttpStatus.*;

@Component
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        return Optional.of(userRepository.findAll().stream()
                        .map(UserMapper.INSTANCE::toUserDto)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new ResponseStatusException(NO_CONTENT, BASE_DE_DADOS_VAZIA));
    }

    public UserDto findById(Long id) {
        User userId = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, ID_NAO_ENCONTRADO));
        return UserMapper.INSTANCE.toUserDto(userId);
    }

    public UserDto save(User user) {
        User userSave = userRepository.save(user);
        return Optional.of(UserMapper.INSTANCE.toUserDto(userSave))
                .orElseThrow(() -> new ResponseStatusException(SERVICE_UNAVAILABLE, SERVIDOR_INDISPONIVEL));
    }

    public UserDto update(Long id, User user) {
        User userId = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, ID_NAO_ENCONTRADO));
        user.setId(userId.getId());
        userRepository.save(user);
        return Optional.of(UserMapper.INSTANCE.toUserDto(user))
                .orElseThrow(() -> new ResponseStatusException(SERVICE_UNAVAILABLE, SERVIDOR_INDISPONIVEL));
    }

    public void deleteById(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, ID_NAO_ENCONTRADO));
        userRepository.deleteById(id);
    }
}