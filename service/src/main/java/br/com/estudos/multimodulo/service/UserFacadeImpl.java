package br.com.estudos.multimodulo.service;

import br.com.estudos.multimodulo.dto.UserDto;
import br.com.estudos.multimodulo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserFacadeImpl implements UserFacade {

    final UserService userService;

    public List<UserDto> findAll() {
        return userService.findAll();
    }

    public UserDto findById(Long id) {
        return userService.findById(id);
    }

    public UserDto save(User user) {
        return userService.save(user);
    }

    public UserDto update(Long id, User user) {
        return userService.update(id, user);
    }

    public void deleteById(Long id) {
        userService.deleteById(id);
    }
}
