package br.com.estudos.multimodulo.controller;

import br.com.estudos.multimodulo.mapper.ControllerMapper;
import br.com.estudos.multimodulo.model.UserControllerRequest;
import br.com.estudos.multimodulo.model.UserControllerResponse;
import br.com.estudos.multimodulo.model.user.UserServiceRequest;
import br.com.estudos.multimodulo.model.user.UserServiceResponse;
import br.com.estudos.multimodulo.service.user.UserServiceFacade;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.estudos.multimodulo.mapper.ControllerMapper.toUserControllerRequest;
import static br.com.estudos.multimodulo.mapper.ControllerMapper.toUserControllerResponse;

@AllArgsConstructor
@Configuration
public class UserControllerFacadeImpl implements UserControllerFacade {

    private final UserServiceFacade serviceFacade;

    public List<UserControllerResponse> findAll() {
        return serviceFacade.findAll().stream()
                .map(ControllerMapper::toUserControllerResponse)
                .collect(Collectors.toList());
    }

    public UserControllerResponse findById(Long id) {
        UserServiceResponse userId = serviceFacade.findById(id);
        return toUserControllerResponse(userId);
    }

    public UserControllerResponse save(UserControllerRequest userControllerRequest) {
        UserServiceRequest userServiceRequest = toUserControllerRequest(userControllerRequest);
        UserServiceResponse userSave = serviceFacade.save(userServiceRequest);
        return toUserControllerResponse(userSave);
    }

    public UserControllerResponse update(Long id, UserControllerRequest userControllerRequest) {
        UserServiceRequest userServiceRequest = toUserControllerRequest(userControllerRequest);
        UserServiceResponse userUpdate = serviceFacade.update(id, userServiceRequest);
        return toUserControllerResponse(userUpdate);
    }

    public void delete(Long id) {
        serviceFacade.deleteById(id);
    }
}