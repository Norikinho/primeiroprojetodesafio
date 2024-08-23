package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseEntity;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseRepository;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.dto.ProfileCourseResponseDTO;

@Service
public class UpdateCourseInfoUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public ProfileCourseResponseDTO execute (CourseEntity courseEntity, String idCourse) 
    {
     var course = this.courseRepository.findByIdEntity(UUID.fromString(idCourse));
     course.setCategory(courseEntity.getCategory());
     course.setName(courseEntity.getName());
     course.setActive(courseEntity.getActive());

     this.courseRepository.save(course);

     var courseDTO = ProfileCourseResponseDTO.builder()
     .active(course.getActive())
     .name(course.getName())
     .category(course.getCategory())
     .build();
      
     return courseDTO;

    }
}