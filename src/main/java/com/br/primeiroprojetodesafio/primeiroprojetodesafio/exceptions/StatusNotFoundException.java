package com.br.primeiroprojetodesafio.primeiroprojetodesafio.exceptions;

public class StatusNotFoundException extends RuntimeException{
    public StatusNotFoundException(){
        super("Status not exists");
    }

}
