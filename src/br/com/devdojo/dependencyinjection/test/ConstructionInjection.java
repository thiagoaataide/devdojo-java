package br.com.devdojo.dependencyinjection.test;

import br.com.devdojo.dependencyinjection.interfaces.ServicoEmail;

public class ConstructionInjection {

    private ServicoEmail servicoEmail;

    public ConstructionInjection(ServicoEmail servicoEmail) {
        this.servicoEmail = servicoEmail;
    }

    public void enviaEmail(String email, String titulo, String mensagem){
        this.servicoEmail.enviaEmail(email,titulo,mensagem);
    }


}
