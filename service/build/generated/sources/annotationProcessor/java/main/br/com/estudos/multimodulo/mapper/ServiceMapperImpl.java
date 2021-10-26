package br.com.estudos.multimodulo.mapper;

import br.com.estudos.multimodulo.entity.UserEntity;
import br.com.estudos.multimodulo.entity.UserEntity.UserEntityBuilder;
import br.com.estudos.multimodulo.model.UserServiceRequest;
import br.com.estudos.multimodulo.model.UserServiceResponse;
import br.com.estudos.multimodulo.model.UserServiceResponse.UserServiceResponseBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-26T13:39:29-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.1.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public UserEntity mapFromEntityToRequest(UserServiceRequest userServiceRequest) {
        if ( userServiceRequest == null ) {
            return null;
        }

        UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( userServiceRequest.getId() );
        userEntity.name( userServiceRequest.getName() );
        userEntity.cpf( userServiceRequest.getCpf() );
        userEntity.email( userServiceRequest.getEmail() );
        userEntity.password( userServiceRequest.getPassword() );
        userEntity.cep( userServiceRequest.getCep() );

        return userEntity.build();
    }

    @Override
    public UserServiceResponse mapFromResponseToEntity(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserServiceResponseBuilder userServiceResponse = UserServiceResponse.builder();

        userServiceResponse.id( userEntity.getId() );
        userServiceResponse.name( userEntity.getName() );
        userServiceResponse.cpf( userEntity.getCpf() );

        return userServiceResponse.build();
    }
}
