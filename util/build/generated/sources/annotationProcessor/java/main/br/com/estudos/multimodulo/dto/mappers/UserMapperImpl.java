package br.com.estudos.multimodulo.dto.mappers;

import br.com.estudos.multimodulo.dto.UserDto;
import br.com.estudos.multimodulo.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-06T11:08:46-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.1.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setCpf( user.getCpf() );
        userDto.setEmail( user.getEmail() );
        userDto.setPassword( user.getPassword() );

        return userDto;
    }
}
