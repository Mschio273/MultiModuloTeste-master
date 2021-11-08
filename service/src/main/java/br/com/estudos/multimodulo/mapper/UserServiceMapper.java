package br.com.estudos.multimodulo.mapper;

import br.com.estudos.multimodulo.entity.UserEntity;
import br.com.estudos.multimodulo.model.user.UserServiceRequest;
import br.com.estudos.multimodulo.model.user.UserServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserServiceMapper {

//    static UserEntity toUserEntityCep(UserServiceRequest userServiceRequest, Cep cep) {
//        return Mappers.getMapper(ServiceMapper.class).mapFromEntityToRequest(userServiceRequest);
//    }

    static UserEntity toUserEntityService(UserServiceRequest userServiceRequest) {
        return Mappers.getMapper(UserServiceMapper.class).mapFromEntityToRequest(userServiceRequest);
    }

    static UserServiceResponse toUserServiceResponse(UserEntity userEntity) {
        return Mappers.getMapper(UserServiceMapper.class).mapFromResponseToEntity(userEntity);
    }

    UserEntity mapFromEntityToRequest(UserServiceRequest userServiceRequest);

    UserServiceResponse mapFromResponseToEntity(UserEntity userEntity);

//    @AfterMapping
//    default void setCep(Cep cep, @MappingTarget UserEntity.UserEntityBuilder userEntityBuilder) {
//        userEntityBuilder.cep(cep);
//    }
}
