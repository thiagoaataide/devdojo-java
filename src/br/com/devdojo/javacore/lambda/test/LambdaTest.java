package br.com.devdojo.javacore.lambda.test;

import br.com.devdojo.javacore.lambda.classes.Carro;
import br.com.devdojo.javacore.lambda.interfaces.CarroPredicate;

import java.util.function.Predicate;

public class LambdaTest {
    public static void main(String[] args) {

        //Classe Anânima
        CarroPredicate carroPredicate = new CarroPredicate() {
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equals("verde");
            }
        };

        System.out.println(carroPredicate.test(new Carro("verde", 2021)));

        //Expressão Lambda
        CarroPredicate carroPredicate2 = (Carro carro) -> carro.getCor().equals("verde");
        Predicate<Carro> carroPredicate3 = (Carro carro) -> carro.getCor().equals("verde"); //trocamos a interface e temos a funcionalidade mantida.
        System.out.println(carroPredicate2.test(new Carro("azul", 2021)));
        System.out.println(carroPredicate3.test(new Carro("verde", 2021)));
    }
}
