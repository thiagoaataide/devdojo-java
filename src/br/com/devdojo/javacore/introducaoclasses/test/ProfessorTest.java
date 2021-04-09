package br.com.devdojo.javacore.introducaoclasses.test;

import br.com.devdojo.javacore.introducaoclasses.classes.Professor;

public class ProfessorTest {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.nome = "Thiago";
        professor.matricula = "2612";
        professor.rg = "6032395";
        professor.cpf = "083.388.654-19";

        Professor professor2 = new Professor();
        professor2.nome = "Michele";
        professor2.matricula = "7652";
        professor2.rg = "12345678";
        professor2.cpf = "171.769.054-87";

        professor = professor2;

        System.out.println(professor);
        System.out.println(professor.nome);
        System.out.println(professor.matricula);
        System.out.println(professor.rg);
        System.out.println(professor.cpf);

        System.out.println(professor2);
        System.out.println(professor2.nome);
        System.out.println(professor2.matricula);
        System.out.println(professor2.rg);
        System.out.println(professor2.cpf);

    }
}
