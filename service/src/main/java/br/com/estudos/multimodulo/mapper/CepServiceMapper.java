package br.com.estudos.multimodulo.mapper;

import br.com.estudos.multimodulo.entity.CepEntity;
import br.com.estudos.multimodulo.model.cep.CepServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CepServiceMapper {



    static CepEntity toCepEntityService(CepServiceRequest cepServiceRequest) {
        return Mappers.getMapper(CepServiceMapper.class).mapFromEntityToRequest(cepServiceRequest);
    }

    static CepServiceRequest toCepServiceResponse(CepEntity cepEntity) {
        return Mappers.getMapper(CepServiceMapper.class).mapFromResponseToEntity(cepEntity);
    }

    CepEntity mapFromEntityToRequest(CepServiceRequest cepServiceRequest);

    CepServiceRequest mapFromResponseToEntity(CepEntity cepEntity);


}
