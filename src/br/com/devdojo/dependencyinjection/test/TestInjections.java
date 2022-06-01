package br.com.devdojo.dependencyinjection.test;

import br.com.devdojo.dependencyinjection.impl.EmailServiceGmail;
import br.com.devdojo.dependencyinjection.impl.EmailServiceOutlook;
import br.com.devdojo.dependencyinjection.interfaces.ServicoEmail;

public class TestInjections {
    public static void main(String[] args) {


        /**
         * Exemplo de Construction Injection
         * */

//        ServicoEmail servicoEmail = new EmailServiceGmail();
        ServicoEmail servicoEmail = new EmailServiceOutlook();
        ConstructionInjection constructionInjection = new ConstructionInjection(servicoEmail);
        constructionInjection.enviaEmail("thiagoaataide@gmail.com", "Construction Injection", "Injeção de dependência pelo construtor");

        /**
         * Exemplo de Setter Injection
         * */
        ServicoEmail servicoEmail1 = new EmailServiceGmail();
        SetterInjection setterInjection = new SetterInjection();
        setterInjection.setServicoEmail(servicoEmail1);
        setterInjection.enviaEmail("thiago@constance.com.br", "Setter Injection", "Injeção de dependÊncia pelo setter");


        /**
         * Exemplo de Method Injection
         * */

        ServicoEmail servicoEmail2 = new EmailServiceGmail();
        MethodInjection methodInjection = new MethodInjection();
        methodInjection.enviarEmail("thiago.ataide@sankhya.com.br", "Method Injection", "Injeção de dependência pelo method", servicoEmail2);





    }
}
