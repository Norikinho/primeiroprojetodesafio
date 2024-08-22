package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseEntity;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseRepository;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute (CourseEntity courseEntity){
        return this.courseRepository.save(courseEntity);
    }
    
}
