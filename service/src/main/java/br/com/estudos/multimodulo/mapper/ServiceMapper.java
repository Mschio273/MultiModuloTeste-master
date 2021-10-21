package br.com.estudos.multimodulo.mapper;

import br.com.estudos.multimodulo.entity.Cep;
import br.com.estudos.multimodulo.entity.UserEntity;
import br.com.estudos.multimodulo.model.UserServiceRequest;
import br.com.estudos.multimodulo.model.UserServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    static UserEntity toUserEntityCep(UserServiceRequest userServiceRequest, Cep cep) {
        return Mappers.getMapper(ServiceMapper.class).mapFromEntityToRequest(userServiceRequest);
    }

    static UserEntity toUserEntityService(UserServiceRequest userServiceRequest) {
        return Mappers.getMapper(ServiceMapper.class).mapFromEntityToRequest(userServiceRequest);
    }

    static UserServiceResponse toUserServiceResponse(UserEntity userEntity) {
        return Mappers.getMapper(ServiceMapper.class).mapFromResponseToEntity(userEntity);
    }

    UserEntity mapFromEntityToRequest(UserServiceRequest userServiceRequest);

    UserServiceResponse mapFromResponseToEntity(UserEntity userEntity);

//    @AfterMapping
//    default void setCep(Cep cep, @MappingTarget UserEntity.UserEntityBuilder userEntityBuilder) {
//        userEntityBuilder.endereco(cep);
//    }
}
