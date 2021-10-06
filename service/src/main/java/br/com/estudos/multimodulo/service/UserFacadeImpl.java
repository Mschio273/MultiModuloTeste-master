package br.com.estudos.multimodulo.service;

import br.com.estudos.multimodulo.dto.UserDto;
import br.com.estudos.multimodulo.dto.mappers.UserMapper;
import br.com.estudos.multimodulo.model.User;
import br.com.estudos.multimodulo.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.estudos.multimodulo.exception.ErrorConstants.ID_NAO_ENCONTRADO;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toUserDto)
                .collect(Collectors.toList());
    }

    public UserDto findById(Long id) {
        User userId = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, ID_NAO_ENCONTRADO));
        return UserMapper.INSTANCE.toUserDto(userId);
    }

    public UserDto save(User user) {
        User userSave = userRepository.save(user);
        return UserMapper.INSTANCE.toUserDto(userSave);
    }

    public UserDto update(Long id, User user) {
        User userId = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, ID_NAO_ENCONTRADO));
        user.setId(userId.getId());
        userRepository.save(user);
        return UserMapper.INSTANCE.toUserDto(user);
    }

    public void deleteById(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, ID_NAO_ENCONTRADO));
        userRepository.deleteById(id);
    }
}