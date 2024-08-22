package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseRepository;

@Service
public class DeleteCourseUseCase {
    
    @Autowired
    private CourseRepository courseRepository;

    public void execute (String idCurso){
      this.courseRepository.deleteById(UUID.fromString(idCurso));
    }
    
}
