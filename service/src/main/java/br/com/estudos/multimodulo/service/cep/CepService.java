package br.com.estudos.multimodulo.service.cep;

import br.com.estudos.multimodulo.CepClient;
import br.com.estudos.multimodulo.entity.CepEntity;
import br.com.estudos.multimodulo.repository.CepRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@AllArgsConstructor
public class CepService {

    private final CepRepository cepRepository;

    public List<CepEntity> findAll() {
        return cepRepository.findAll();
    }

    public CepEntity findCepById(Long id) {
        return cepRepository.findById(id)
                .orElseThrow();
    }

    public CepEntity saveCep(CepEntity cep) {
        CepEntity byCep = findByCep(cep.getCep());
        return cepRepository.save(byCep);
    }
    public CepEntity updateCep(CepEntity cep, Long id) {
        CepEntity cepId = cepRepository.findById(id)
                .orElseThrow();
        cep.setId(cepId.getId());
        return cep;
    }

    public void deleteById(Long id) {
        cepRepository.deleteById(id);
    }

    public static CepEntity findByCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return CepClient.getRestTemplate().getForObject(url, CepEntity.class);
    }
}