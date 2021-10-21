package br.com.estudos.multimodulo.mapper;

import br.com.estudos.multimodulo.model.UserControllerRequest;
import br.com.estudos.multimodulo.model.UserControllerResponse;
import br.com.estudos.multimodulo.model.UserControllerResponse.UserControllerResponseBuilder;
import br.com.estudos.multimodulo.model.UserServiceRequest;
import br.com.estudos.multimodulo.model.UserServiceRequest.UserServiceRequestBuilder;
import br.com.estudos.multimodulo.model.UserServiceResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-20T11:07:56-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.1.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class ControllerMapperImpl implements ControllerMapper {

    @Override
    public UserServiceRequest mapFromEntityUserController(UserControllerRequest userControllerRequest) {
        if ( userControllerRequest == null ) {
            return null;
        }

        UserServiceRequestBuilder userServiceRequest = UserServiceRequest.builder();

        userServiceRequest.id( userControllerRequest.getId() );
        userServiceRequest.name( userControllerRequest.getName() );
        userServiceRequest.cpf( userControllerRequest.getCpf() );
        userServiceRequest.email( userControllerRequest.getEmail() );
        userServiceRequest.password( userControllerRequest.getPassword() );
        userServiceRequest.cep( userControllerRequest.getCep() );

        return userServiceRequest.build();
    }

    @Override
    public UserControllerResponse mapFromServiceRequestToResponse(UserServiceResponse userServiceResponse) {
        if ( userServiceResponse == null ) {
            return null;
        }

        UserControllerResponseBuilder userControllerResponse = UserControllerResponse.builder();

        userControllerResponse.id( userServiceResponse.getId() );
        userControllerResponse.name( userServiceResponse.getName() );
        userControllerResponse.cpf( userServiceResponse.getCpf() );
        userControllerResponse.endereco( userServiceResponse.getEndereco() );

        return userControllerResponse.build();
    }
}
