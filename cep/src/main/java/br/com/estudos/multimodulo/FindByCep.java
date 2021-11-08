//package br.com.estudos.multimodulo;
//
//import br.com.estudos.multimodulo.entity.Cep;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class FindByCep {
//
//    private static final String URL = "https://viacep.com.br/ws/";
//
//    public static Cep findByCep(String cep) {
//        RestTemplate restTemplate = CepClient.getRestTemplate();
//        return restTemplate.getForObject(URL + cep + "/json", Cep.class);
//    }
//}
