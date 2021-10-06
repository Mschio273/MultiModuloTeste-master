package br.com.estudos.multimodulo.service.repository;

import br.com.estudos.multimodulo.model.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<Cep, Long> {

    Cep findByCep(String cep);
}
