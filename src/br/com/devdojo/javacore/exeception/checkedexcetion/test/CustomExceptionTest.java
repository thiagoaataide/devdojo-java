package br.com.devdojo.javacore.exeception.checkedexcetion.test;

import br.com.devdojo.javacore.exeception.customexception.LoginInvalidException;

public class CustomExceptionTest {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidException e) {
            e.printStackTrace();
        }
    }

    private static void logar() throws LoginInvalidException {
        String usuarioBancoDeDados = "Goku";
        String senhaBancoDeDados = "1234";
        String usuarioDigitado = "Pikolo";
        String senhaDigitada = "1234";
        if (!usuarioBancoDeDados.equals(usuarioDigitado) || senhaBancoDeDados.equals(senhaDigitada)) {
            throw new LoginInvalidException();
        } else {
            System.out.println("Logado");
        }
    }
}
