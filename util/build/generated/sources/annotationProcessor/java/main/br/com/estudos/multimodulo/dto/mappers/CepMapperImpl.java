package br.com.estudos.multimodulo.dto.mappers;

import br.com.estudos.multimodulo.dto.CepDto;
import br.com.estudos.multimodulo.model.Cep;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-06T13:53:36-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.1.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class CepMapperImpl implements CepMapper {

    @Override
    public CepDto toCepDto(Cep cep) {
        if ( cep == null ) {
            return null;
        }

        CepDto cepDto = new CepDto();

        cepDto.setId( cep.getId() );
        cepDto.setCep( cep.getCep() );
        cepDto.setLogradouro( cep.getLogradouro() );
        cepDto.setComplemento( cep.getComplemento() );
        cepDto.setBairro( cep.getBairro() );
        cepDto.setLocalidade( cep.getLocalidade() );
        cepDto.setUf( cep.getUf() );
        cepDto.setIbge( cep.getIbge() );

        return cepDto;
    }
}
