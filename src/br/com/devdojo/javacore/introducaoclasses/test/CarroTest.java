package br.com.devdojo.javacore.introducaoclasses.test;

import br.com.devdojo.javacore.introducaoclasses.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {

        Carro carro = new Carro();
        carro.modelo = "Fusca";
        carro.placa = "PCT-3161";
        carro.velocidadeMaxima = 160f;
        System.out.println(carro.modelo);
        System.out.println(carro.placa);
        System.out.println(carro.velocidadeMaxima);

    }
}
