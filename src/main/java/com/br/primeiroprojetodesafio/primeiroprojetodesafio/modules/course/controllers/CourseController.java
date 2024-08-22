package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseEntity;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseRepository;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.dto.CreateCourseDTO;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases.CreateCourseUseCase;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/primeiroprojetodesafio")
public class CourseController {
    @Autowired
    private CreateCourseUseCase createCourseUseCase;
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/cursos")
    public CourseEntity create(@RequestBody CreateCourseDTO createCourseDTO, HttpServletRequest request) {
        var courseEntity = CourseEntity.builder()
        .name(createCourseDTO.getName())
        .category(createCourseDTO.getCategory())
        .active(createCourseDTO.getActive())
        .build();
        
        return createCourseUseCase.execute(courseEntity);
    }

    @GetMapping("/cursos")
    public List<CourseEntity> all() {
        return courseRepository.findAll();
    }

    
    
}
