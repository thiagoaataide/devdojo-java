package br.com.devdojo.javacore.padroesdeprojeto.test;

import br.com.devdojo.javacore.padroesdeprojeto.classes.Pessoa;

public class testePessoa {
    public static void main(String[] args) {
//        Pessoa p = new Pessoa("Thiago","Alberto","Silva","Mascherano","Carlos");
        Pessoa p = new Pessoa.PessoaBuilder("Michele")
                .apelido("Mascherano")
                .ultimoNome("Silva")
                .nomeDoMeio("Alberto")
                .nomeDoPai("Carlos Alberto")
                .build();

        System.out.println(p);



    }
}
