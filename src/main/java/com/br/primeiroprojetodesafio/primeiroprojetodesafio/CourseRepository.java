package com.br.primeiroprojetodesafio.primeiroprojetodesafio;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID>{
    Optional<CourseEntity> findByNameAndCategory(String name, String type);
    CourseEntity findByIdEntity(UUID idEntity);


}
