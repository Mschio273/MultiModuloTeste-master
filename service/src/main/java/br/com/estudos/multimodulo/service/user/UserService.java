package br.com.estudos.multimodulo.service.user;

import br.com.estudos.multimodulo.CepClient;
import br.com.estudos.multimodulo.entity.CepEntity;
import br.com.estudos.multimodulo.entity.UserEntity;
import br.com.estudos.multimodulo.exception.NotFoundException;
import br.com.estudos.multimodulo.model.user.UserServiceRequest;
import br.com.estudos.multimodulo.model.user.UserServiceResponse;
import br.com.estudos.multimodulo.repository.UserRepository;
import br.com.estudos.multimodulo.service.cep.CepService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.estudos.multimodulo.exception.ErrorConstants.ID_NAO_ENCONTRADO;
import static br.com.estudos.multimodulo.mapper.UserServiceMapper.toUserEntityService;

@Component
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CepService cepService;

    public List<UserServiceResponse> findAll() {
        return userRepository.findAll().stream()
                .map(x -> new UserServiceResponse(x.getId(), x.getName(), x.getCpf(), findByCep(x.getEndereco().getCep())))
                .collect(Collectors.toList());
    }

    public UserServiceResponse findById(Long id) {
        UserEntity userId = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ID_NAO_ENCONTRADO));
        CepEntity byCep = findByCep(userId.getEndereco().getCep());
        return UserServiceResponse.builder()
                .endereco(byCep)
                .id(userId.getId())
                .cpf(userId.getCpf())
                .name(userId.getName())
                .build();
    }

    public UserServiceResponse save(UserServiceRequest user) {
        CepEntity cepEntity = cepService.saveCep(findByCep(user.getCep()));
        UserEntity userEntity = toUserEntityService(user);
        UserEntity userSave = userRepository.save(userEntity);
        return UserServiceResponse.builder()
                .endereco(cepEntity)
                .id(userSave.getId())
                .cpf(userSave.getCpf())
                .name(userSave.getName())
                .build();
    }

    public UserServiceResponse update(Long id, UserServiceRequest user) {
        UserEntity userId = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ID_NAO_ENCONTRADO));
        user.setId(userId.getId());
        CepEntity byCep = findByCep(user.getCep());
        return UserServiceResponse.builder()
                .endereco(byCep)
                .id(user.getId())
                .cpf(user.getCpf())
                .name(user.getName())
                .build();
    }

    public void deleteById(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ID_NAO_ENCONTRADO));
        userRepository.deleteById(id);
    }

    private CepEntity findByCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return CepClient.getRestTemplate().getForObject(url, CepEntity.class);
    }

//    public static CepEntity findByCep(String cep) {
//        final String URL = "https://viacep.com.br/ws/";
//
//        RestTemplate restTemplate = CepClient.getRestTemplate();
//        return restTemplate.getForObject(URL + cep + "/json", CepEntity.class);
//    }
}