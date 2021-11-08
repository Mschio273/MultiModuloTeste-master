package br.com.estudos.multimodulo.service.user;

import br.com.estudos.multimodulo.model.user.UserServiceRequest;
import br.com.estudos.multimodulo.model.user.UserServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@AllArgsConstructor
@Configuration
public class UserServiceFacadeImpl implements UserServiceFacade {

    final UserService userService;

    public List<UserServiceResponse> findAll() {
        return userService.findAll();
    }

    public UserServiceResponse findById(Long id) {
        return userService.findById(id);
    }

    public UserServiceResponse save(UserServiceRequest user) {
        return userService.save(user);
    }

    public UserServiceResponse update(Long id, UserServiceRequest user) {
        return userService.update(id, user);
    }

    public void deleteById(Long id) {
        userService.deleteById(id);
    }
}