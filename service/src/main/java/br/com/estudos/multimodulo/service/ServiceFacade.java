package br.com.estudos.multimodulo.service;

import br.com.estudos.multimodulo.model.UserServiceRequest;
import br.com.estudos.multimodulo.model.UserServiceResponse;

import java.util.List;

public interface ServiceFacade {

    List<UserServiceResponse> findAll();

    UserServiceResponse findById(Long id);

    UserServiceResponse save(UserServiceRequest user);

    UserServiceResponse update(Long id, UserServiceRequest user);

    void deleteById(Long id);
}
