package br.com.estudos.multimodulo.service;

import br.com.estudos.multimodulo.model.UserServiceRequest;
import br.com.estudos.multimodulo.model.UserServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@AllArgsConstructor
@Configuration
public class ServiceFacadeImpl implements ServiceFacade {

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
