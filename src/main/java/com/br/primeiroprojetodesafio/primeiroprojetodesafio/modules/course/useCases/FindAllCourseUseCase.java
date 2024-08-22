package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseEntity;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseRepository;

@Service
public class FindAllCourseUseCase {
     @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute (){
        return courseRepository.findAll();
    }
    
 
}
