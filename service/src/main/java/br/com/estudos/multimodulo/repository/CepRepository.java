package br.com.estudos.multimodulo.repository;

import br.com.estudos.multimodulo.entity.Cep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<Cep, Long> {
}
