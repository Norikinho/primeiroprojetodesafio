package com.br.primeiroprojetodesafio.primeiroprojetodesafio.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.primeiroprojetodesafio.primeiroprojetodesafio.ActiveEnum;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseEntity;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.CourseRepository;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.exceptions.CourseNotFoundException;
import com.br.primeiroprojetodesafio.primeiroprojetodesafio.exceptions.StatusNotFoundException;

@Service
public class UpdateStatusUseCase {
  @Autowired
  private CourseRepository courseRepository;

  public void execute(CourseEntity courseEntity, String idCurso) {
    try {
      ActiveEnum.valueOf(courseEntity.getActive());
    } catch (Exception e) {
      throw new StatusNotFoundException();
    }

    try {
      CourseEntity course = this.courseRepository.findByIdEntity(UUID.fromString(idCurso));
      course.setActive(courseEntity.getActive());
      courseRepository.save(course);
    } catch (Exception e) {
      throw new CourseNotFoundException();
    }

  }

}
