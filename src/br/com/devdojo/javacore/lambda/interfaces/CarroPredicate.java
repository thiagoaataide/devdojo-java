package br.com.devdojo.javacore.lambda.interfaces;


import br.com.devdojo.javacore.lambda.classes.Carro;

@FunctionalInterface
public interface CarroPredicate {
    boolean teste(Carro carro);
}
