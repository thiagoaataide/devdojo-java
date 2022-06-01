package br.com.devdojo.dependencyinjection.test;

import br.com.devdojo.dependencyinjection.interfaces.ServicoEmail;

public class SetterInjection {
    private ServicoEmail servicoEmail;

    public ServicoEmail getServicoEmail() {
        return servicoEmail;
    }

    public void setServicoEmail(ServicoEmail servicoEmail) {
        this.servicoEmail = servicoEmail;
    }

    public void enviaEmail(String email, String titulo, String mensagem){
        this.servicoEmail.enviaEmail(email,titulo,mensagem);
    }
}
