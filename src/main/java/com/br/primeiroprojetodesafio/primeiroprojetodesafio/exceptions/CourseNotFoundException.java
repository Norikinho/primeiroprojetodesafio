package com.br.primeiroprojetodesafio.primeiroprojetodesafio.exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(){
        super("Course not exists");
    }

}
