package br.com.devdojo.javacore.strings.test;

import java.util.Locale;

public class StringTest {
    public static void main(String[] args) {
//        String nome = "Thiago";
//        String sobrenome = new String("Ataide");
//
//        System.out.println(nome +" "+ sobrenome);

        String nome = "Thiago";
        nome = nome.concat(" Alberto");
        String nome2 = "Thiago";
        System.out.println(nome);
        System.out.println(nome2);

        String nome3 = new String("Ataide");

        /*
        * Para a variável nome3 está ocorrendo algumas ações pelo Java
        * 1 - Criando um variável de referência [nome3]
        * 2 - Criando um objeto do tipo String
        * 3 - Uma String no pool de Strings
        * */

        String teste = "Goku";
        String teste2 = "goku";
        String numeros = "0123456789";
        System.out.println(teste.charAt(2));
        System.out.println(teste.equals(teste2));
        System.out.println(teste.equalsIgnoreCase(teste2));
        System.out.println(teste.length());
        System.out.println(teste.replace('u','A'));
        System.out.println(teste.toLowerCase());
        System.out.println(teste.toUpperCase());

        System.out.println(numeros.substring(0,5));
        /* Particularidade do método substring
        O primeiro parâmetro é sempre considerado como um Array iniciando em ZERO;
        Já o segundo parâmetro é um Array iniciando em UM
        Por isso o que é colocado no segundo parâmetro sempre virá com um caractere a menos.
        * */



    }
}
