package br.com.estudos.multimodulo.repository;

import br.com.estudos.multimodulo.entity.CepEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepRepository extends JpaRepository<CepEntity, Long> {
}
