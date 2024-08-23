package com.br.primeiroprojetodesafio.primeiroprojetodesafio.exceptions;

public class MinimumRequiredFieldsException extends RuntimeException{
    public MinimumRequiredFieldsException(){
        super("Please, fill minimum fields required");
    }

}
