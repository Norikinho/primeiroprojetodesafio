package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseEntity;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.dto.CreateCourseDTO;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.dto.ProfileCourseResponseDTO;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases.CreateCourseUseCase;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases.DeleteCourseUseCase;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases.FindAllCourseUseCase;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases.ProfileCourseUseCase;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases.UpdateStatusUseCase;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/primeiroprojetodesafio")
public class CourseController {
    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private FindAllCourseUseCase findAllCourseUseCase;

    @Autowired
    private ProfileCourseUseCase profileCourseUseCase;


    @Autowired
    private UpdateStatusUseCase updateStatusUseCase;

    @PostMapping("/cursos")
    public CourseEntity create(@RequestBody CreateCourseDTO createCourseDTO) {
        var courseEntity = CourseEntity.builder()
                .name(createCourseDTO.getName())
                .category(createCourseDTO.getCategory())
                .active(createCourseDTO.getActive())
                .build();

        return createCourseUseCase.execute(courseEntity);
    }

    @GetMapping("/cursos")
    public List<CourseEntity> all() {
        return findAllCourseUseCase.execute();
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<Object> getOne(@PathVariable String id) {
        // var idCourse = request.getAttribute("id");

        try {
            var curso = this.profileCourseUseCase
                    .execute(UUID.fromString(id));
            return ResponseEntity.ok().body(curso);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/curso/{id}")
    public void deleteCourse(@PathVariable String id) {
        deleteCourseUseCase.execute(id);
    }

    @PatchMapping("/curso/{id}/active")
    public ResponseEntity<CourseEntity>  updateActive(@RequestBody CourseEntity courseEntity, @PathVariable String id) {
           var curso = this.updateStatusUseCase.execute(courseEntity, id);
            return ResponseEntity.ok().body(curso);
    }

}
