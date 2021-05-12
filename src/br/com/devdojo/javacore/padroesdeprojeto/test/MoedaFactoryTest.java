package br.com.devdojo.javacore.padroesdeprojeto.test;

import br.com.devdojo.javacore.padroesdeprojeto.classes.Moeda;
import br.com.devdojo.javacore.padroesdeprojeto.classes.MoedaFactory;
import br.com.devdojo.javacore.padroesdeprojeto.classes.Pais;

public class MoedaFactoryTest {
    public static void main(String[] args) {
        Moeda moeda = MoedaFactory.criarMoeda(Pais.BRAZIL);
        System.out.println(moeda.getSimbolo());
    }
}
