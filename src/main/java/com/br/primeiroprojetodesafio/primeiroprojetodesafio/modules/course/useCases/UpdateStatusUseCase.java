package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseEntity;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseRepository;

@Service
public class UpdateStatusUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute (CourseEntity courseEntity, String idCurso){
      Optional<CourseEntity> course =  this.courseRepository.findById(UUID.fromString(idCurso));
      
     if (course.isPresent())
     {
        course.get().setActive(courseEntity.getActive());
        
        
     };
     return  this.courseRepository.save(courseEntity);
    }
    
}
