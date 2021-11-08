package br.com.estudos.multimodulo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CepClient {
    public static RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
//    private static RestTemplate restTemplate;
//
//    private CepClient() {
//    }
//
//    public static  RestTemplate getRestTemplate() {
//        if (restTemplate == null) {
//            restTemplate = new RestTemplate();
//        }
//        return restTemplate;
//    }
}
