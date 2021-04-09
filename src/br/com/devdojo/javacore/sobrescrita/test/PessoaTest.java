package br.com.devdojo.javacore.sobrescrita.test;

import br.com.devdojo.javacore.sobrescrita.classes.Pessoa;

public class PessoaTest {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setNome("Joaquina na Esquina");
        p.setIdade(300);

        System.out.println(p.toString());


    }
}
