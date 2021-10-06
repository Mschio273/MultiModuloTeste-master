package br.com.estudos.multimodulo.service;

import br.com.estudos.multimodulo.dto.UserDto;
import br.com.estudos.multimodulo.model.User;

import java.util.List;

public interface UserFacade {

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto save(User user);

    UserDto update(Long id, User user);

    void deleteById(Long id);
}
