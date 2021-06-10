package br.com.devdojo.javacore.optional.test;

import java.util.Optional;

public class OptionalTest1 {
    private String nome;
    public static void main(String[] args) {
        OptionalTest1 ot = new OptionalTest1();

        //Nesta forma de declaração, temos certeza que a variável passada ao Optional não é nula.
        Optional<String> optional1 = Optional.of("ot.nome");

        //Inicializar o Optional vazio.
        Optional<String> optional2 = Optional.empty();

        //Não há certeza que a variável é nula ou não.
        Optional<String> optional3 = Optional.ofNullable(ot.nome);


        System.out.println(optional1);
        System.out.println(optional2);
        System.out.println(optional3);

        //Buscando valores
        System.out.println(optional1.get());

        if(optional2.isPresent())
        System.out.println(optional2.get());

        System.out.println(optional2.orElse("O valor veio NULL, logo você está lendo esta mensagem!"));
    }
}
