package com.br.primeiroprojetodesafio.primeiroprojetodesafio.exceptions;

public class CourseFoundException extends RuntimeException{
    public CourseFoundException(){
        super("Course already exists");
    }

}
