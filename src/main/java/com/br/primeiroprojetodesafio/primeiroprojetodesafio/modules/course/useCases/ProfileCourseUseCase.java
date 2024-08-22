package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseRepository;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.exceptions.CourseNotFoundException;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.dto.ProfileCourseResponseDTO;

@Service
public class ProfileCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public ProfileCourseResponseDTO execute (UUID idCourse)
    {
     var course = this.courseRepository.findById(idCourse)
     .orElseThrow(()-> {throw new CourseNotFoundException();})   ;
    
     var courseDTO = ProfileCourseResponseDTO.builder()
     .active(course.getActive())
     .name(course.getName())
     .category(course.getCategory())
     .build();

     return courseDTO;
    }
    
        
}
