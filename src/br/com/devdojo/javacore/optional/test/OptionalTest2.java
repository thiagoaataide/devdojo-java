package br.com.devdojo.javacore.optional.test;

import br.com.devdojo.javacore.optional.classes.Seguradora;

import java.util.Optional;

public class OptionalTest2 {
    public static void main(String[] args) {
        Seguradora s = new Seguradora("Bradesco Seguros");
        System.out.println(obterNomeSeguradoraOptional(s));


    }

    public static String obterNomeSeguradoraOptional(Seguradora seguradora){
        /**
         * map() -> retorna um Optional dentro de um Optional
         * flatMap() -> retornar o Optional mais interno e prover a possibilidade de utilizar o orElse();
         *              Quando utilizado em conjunto com o orElse(), já retorna o dado no tipo específico do Optional,
         *              e não um Optional mais interno.
         * */
//        System.out.println(Optional.ofNullable(seguradora).flatMap(Seguradora::getNome));
//        System.out.println(Optional.ofNullable(seguradora).flatMap(Seguradora::getNome).orElse("vazio"));
        return "";
    }

    public static String obterNomeSeguradora(Seguradora seguradora){
        String nome = "";
        if(seguradora.getNome() != null){
            nome = seguradora.getNome();
        }

        return nome;
    }
}
