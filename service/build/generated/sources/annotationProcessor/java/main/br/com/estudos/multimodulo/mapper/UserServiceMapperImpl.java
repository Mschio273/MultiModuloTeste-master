package br.com.estudos.multimodulo.mapper;

import br.com.estudos.multimodulo.entity.UserEntity;
import br.com.estudos.multimodulo.entity.UserEntity.UserEntityBuilder;
import br.com.estudos.multimodulo.model.user.UserServiceRequest;
import br.com.estudos.multimodulo.model.user.UserServiceResponse;
import br.com.estudos.multimodulo.model.user.UserServiceResponse.UserServiceResponseBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-08T10:33:20-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.1.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class UserServiceMapperImpl implements UserServiceMapper {

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
        userServiceResponse.endereco( userEntity.getEndereco() );

        return userServiceResponse.build();
    }
}
