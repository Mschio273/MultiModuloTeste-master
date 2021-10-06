package br.com.estudos.multimodulo.service;

import br.com.estudos.multimodulo.dto.ServiceRequestDTO;
import br.com.estudos.multimodulo.dto.ServiceResponseDTO;

import java.util.List;

public interface UserFacade {

    List<ServiceResponseDTO> findAll();

    List<ServiceResponseDTO> findById(Long id);

    ServiceResponseDTO save(ServiceRequestDTO requestDTO);

    ServiceResponseDTO update(Long id, ServiceRequestDTO requestDTO);

    void deleteById(Long id);
}
