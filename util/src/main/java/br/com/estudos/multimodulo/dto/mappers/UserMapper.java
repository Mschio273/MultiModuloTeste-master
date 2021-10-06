package br.com.estudos.multimodulo.dto.mappers;

import br.com.estudos.multimodulo.dto.UserDto;
import br.com.estudos.multimodulo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserDto toUserDto(User user);
}
