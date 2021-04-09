package br.com.devdojo.javacore.introducaoclasses.test;

import br.com.devdojo.javacore.introducaoclasses.classes.Estudante;

public class EstudanteTest {
    public static void main(String[] args) {
        Estudante joao = new Estudante();
        /*A variável joao é uma referencia do tipo Aluno,
        * que por sua vez aponta para um endereço de memória
        * para alocar um objeto do tipo Aluno(nome, matrícula, idade)*/

        joao.nome = "João";
        joao.matricula = "1212";
        joao.idade = 15;

        System.out.println(joao.nome);
        System.out.println(joao.matricula);
        System.out.println(joao.idade);

    }
}
