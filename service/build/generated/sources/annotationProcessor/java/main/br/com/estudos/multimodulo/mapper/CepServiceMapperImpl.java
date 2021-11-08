package br.com.estudos.multimodulo.mapper;

import br.com.estudos.multimodulo.entity.CepEntity;
import br.com.estudos.multimodulo.entity.CepEntity.CepEntityBuilder;
import br.com.estudos.multimodulo.model.cep.CepServiceRequest;
import br.com.estudos.multimodulo.model.cep.CepServiceRequest.CepServiceRequestBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-08T10:33:20-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.1.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class CepServiceMapperImpl implements CepServiceMapper {

    @Override
    public CepEntity mapFromEntityToRequest(CepServiceRequest cepServiceRequest) {
        if ( cepServiceRequest == null ) {
            return null;
        }

        CepEntityBuilder cepEntity = CepEntity.builder();

        cepEntity.id( cepServiceRequest.getId() );
        cepEntity.cep( cepServiceRequest.getCep() );
        cepEntity.logradouro( cepServiceRequest.getLogradouro() );
        cepEntity.complemento( cepServiceRequest.getComplemento() );
        cepEntity.bairro( cepServiceRequest.getBairro() );
        cepEntity.localidade( cepServiceRequest.getLocalidade() );
        cepEntity.uf( cepServiceRequest.getUf() );
        cepEntity.ibge( cepServiceRequest.getIbge() );

        return cepEntity.build();
    }

    @Override
    public CepServiceRequest mapFromResponseToEntity(CepEntity cepEntity) {
        if ( cepEntity == null ) {
            return null;
        }

        CepServiceRequestBuilder cepServiceRequest = CepServiceRequest.builder();

        cepServiceRequest.id( cepEntity.getId() );
        cepServiceRequest.cep( cepEntity.getCep() );
        cepServiceRequest.logradouro( cepEntity.getLogradouro() );
        cepServiceRequest.complemento( cepEntity.getComplemento() );
        cepServiceRequest.bairro( cepEntity.getBairro() );
        cepServiceRequest.localidade( cepEntity.getLocalidade() );
        cepServiceRequest.uf( cepEntity.getUf() );
        cepServiceRequest.ibge( cepEntity.getIbge() );

        return cepServiceRequest.build();
    }
}
