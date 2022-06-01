package br.com.devdojo.dependencyinjection.impl;

import br.com.devdojo.dependencyinjection.interfaces.ServicoEmail;

public class EmailServiceOutlook implements ServicoEmail {
    @Override
    public void enviaEmail(String email, String titulo, String mensagem) {
        System.out.println("Serviço Outlook \n " +
                "Email: "+ email + "\n " +
                "Título: " + titulo +"\n" +
                "Mensagem: " + mensagem);
    }
}
