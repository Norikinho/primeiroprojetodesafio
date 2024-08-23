package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseEntity;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseRepository;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.exceptions.MinimumRequiredFieldsException;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity) {
        try {
            var exists = courseEntity.getCategory().isEmpty() || courseEntity.getName().isEmpty();
        } catch (Exception e) {
            throw new MinimumRequiredFieldsException();
        }

        return this.courseRepository.save(courseEntity);
    }

}
