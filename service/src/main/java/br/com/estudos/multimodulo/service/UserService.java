package br.com.estudos.multimodulo.service;

import br.com.estudos.multimodulo.CepClient;
import br.com.estudos.multimodulo.entity.Cep;
import br.com.estudos.multimodulo.entity.UserEntity;
import br.com.estudos.multimodulo.exception.NotFoundException;
import br.com.estudos.multimodulo.mapper.ServiceMapper;
import br.com.estudos.multimodulo.model.UserServiceRequest;
import br.com.estudos.multimodulo.model.UserServiceResponse;
import br.com.estudos.multimodulo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.estudos.multimodulo.exception.ErrorConstants.ID_NAO_ENCONTRADO;
import static br.com.estudos.multimodulo.mapper.ServiceMapper.*;

@Component
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CepClient cepClient;

    public List<UserServiceResponse> findAll() {
        return userRepository.findAll().stream()
                .map(ServiceMapper::toUserServiceResponse)
                .collect(Collectors.toList());
    }

    public UserServiceResponse findById(Long id) {
        UserEntity userId = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ID_NAO_ENCONTRADO));
        return toUserServiceResponse(userId);
    }

    public UserServiceResponse save(UserServiceRequest user) {
        Cep byCep = findByCep(user.getCep());
        UserEntity userEntity = toUserEntityCep(user, byCep);
        UserEntity userSave = userRepository.save(userEntity);
        return toUserServiceResponse(userSave);
    }

    public UserServiceResponse update(Long id, UserServiceRequest user) {
        UserEntity userId = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ID_NAO_ENCONTRADO));
        user.setId(userId.getId());
        UserEntity userEntity = toUserEntityService(user);
        UserEntity userSave = userRepository.save(userEntity);
        return toUserServiceResponse(userSave);
    }

    public void deleteById(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ID_NAO_ENCONTRADO));
        userRepository.deleteById(id);
    }

    private Cep findByCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return cepClient.getRestTemplate().getForObject(url, Cep.class);
    }
}