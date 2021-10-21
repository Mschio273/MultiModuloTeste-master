package br.com.estudos.multimodulo.repository;

import br.com.estudos.multimodulo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
