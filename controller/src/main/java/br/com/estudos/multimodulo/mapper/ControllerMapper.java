package br.com.estudos.multimodulo.mapper;

import br.com.estudos.multimodulo.model.UserControllerRequest;
import br.com.estudos.multimodulo.model.UserControllerResponse;
import br.com.estudos.multimodulo.model.user.UserServiceRequest;
import br.com.estudos.multimodulo.model.user.UserServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ControllerMapper {

    static UserServiceRequest toUserControllerRequest(UserControllerRequest userControllerRequest) {
        return Mappers.getMapper(ControllerMapper.class).mapFromEntityUserController(userControllerRequest);
    }

    static UserControllerResponse toUserControllerResponse(UserServiceResponse userServiceResponse) {
        return Mappers.getMapper(ControllerMapper.class).mapFromServiceRequestToResponse(userServiceResponse);
    }
    UserServiceRequest mapFromEntityUserController(UserControllerRequest userControllerRequest);

    UserControllerResponse mapFromServiceRequestToResponse(UserServiceResponse userServiceResponse);

}
