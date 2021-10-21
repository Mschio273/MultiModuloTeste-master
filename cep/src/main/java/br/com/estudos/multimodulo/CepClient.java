package br.com.estudos.multimodulo;

import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@NoArgsConstructor
public class CepClient {

    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
