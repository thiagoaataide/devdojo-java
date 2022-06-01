package br.com.devdojo.dependencyinjection.test;

import br.com.devdojo.dependencyinjection.interfaces.ServicoEmail;

public class MethodInjection {

    public void enviarEmail(String email, String titulo, String mensagem, ServicoEmail servicoEmail){
        servicoEmail.enviaEmail(email,titulo,mensagem);
    }
}
