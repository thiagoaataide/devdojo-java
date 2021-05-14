package br.com.devdojo.javacore.lambda.test;

import br.com.devdojo.javacore.lambda.classes.Carro;
import br.com.devdojo.javacore.lambda.interfaces.CarroPredicate;

public class LambdaTest {
    public static void main(String[] args) {

        //Classe Anânima
        CarroPredicate carroPredicate = new CarroPredicate() {
            @Override
            public boolean teste(Carro carro) {
                return carro.getCor().equals("verde");
            }
        };

        System.out.println(carroPredicate.teste(new Carro("verde", 2021)));

        //Expressão Lambda
        CarroPredicate carroPredicate2 = (Carro carro) -> carro.getCor().equals("verde");
        System.out.println(carroPredicate2.teste(new Carro("azul", 2021)));
    }
}
