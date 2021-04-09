package br.com.devdojo.javacore.modificadorfinal.test;

import br.com.devdojo.javacore.modificadorfinal.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro c = new Carro();
        c.setNome("Strada");
        c.setMarca("Fiat");

        System.out.println(c.getComprador());
        c.getComprador().setNome("Goku");
        System.out.println(c.getComprador());


//        Carro.VELOCIDADE_FINAL = 300;

    }
}
