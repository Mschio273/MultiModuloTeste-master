package br.com.estudos.multimodulo.dto.mappers;

import br.com.estudos.multimodulo.dto.CepDto;
import br.com.estudos.multimodulo.model.Cep;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CepMapper {

    CepMapper INSTANCE = Mappers.getMapper(CepMapper.class);


    CepDto toCepDto(Cep cep);
}
