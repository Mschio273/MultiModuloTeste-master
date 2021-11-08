package br.com.estudos.multimodulo.service.user;

import br.com.estudos.multimodulo.model.user.UserServiceRequest;
import br.com.estudos.multimodulo.model.user.UserServiceResponse;

import java.util.List;

public interface UserServiceFacade {

    List<UserServiceResponse> findAll();

    UserServiceResponse findById(Long id);

    UserServiceResponse save(UserServiceRequest user);

    UserServiceResponse update(Long id, UserServiceRequest user);

    void deleteById(Long id);
}
