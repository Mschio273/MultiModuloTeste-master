package br.com.estudos.multimodulo.controller;

import br.com.estudos.multimodulo.model.UserControllerRequest;
import br.com.estudos.multimodulo.model.UserControllerResponse;

import java.util.List;

public interface ControllerFacade {

    List<UserControllerResponse> findAll();

    UserControllerResponse findById(Long id);

    UserControllerResponse save(UserControllerRequest userControllerRequest);

    UserControllerResponse update(Long id, UserControllerRequest userControllerRequest);

    void delete(Long Id);
}
