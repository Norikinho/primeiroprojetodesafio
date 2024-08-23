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
      CourseEntity course =  this.courseRepository.findByIdEntity(UUID.fromString(idCurso));
       if (course != null){
        course.setActive(courseEntity.getActive());
        
       }
       return courseRepository.save(course);
       
    }
    
}
