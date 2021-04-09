package br.com.devdojo.javacore.exeception.customexception;

public class LoginInvalidException extends Exception{

    public LoginInvalidException(){
        super("Usuário ou Senha inválidos!");
    }
}
