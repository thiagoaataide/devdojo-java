package br.com.devdojo.javacore.colecoes.test;

import br.com.devdojo.javacore.colecoes.classes.Celular;

public class EqualsTest {
    public static void main(String[] args) {
        String nome1 = "Thiago Alberto";
        String nome2 = new String("Thiago Alberto");
        Integer int1 = 5;
        Integer int2 = new Integer(5) ;
        System.out.println(nome1==nome2);//false
        System.out.println(nome1.equals(nome2));//true
        System.out.println(int1==int2);//false
        System.out.println(int1.equals(int2));//false

        System.out.println("--------------------------------------");

        Celular c1 = new Celular("iPhone","123456");
        Celular c2 = new Celular("iPhone","12345");
        //false porque o equals da classe Object, e neste caso ele rotornará falso se os objetos estiverem em endereços distintos;
        System.out.println(c1.equals(c2));

    }
}
