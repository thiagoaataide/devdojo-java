package br.com.devdojo.javacore.introducaometodos.test;

import br.com.devdojo.javacore.introducaometodos.classes.Professor;

/* DevDojo
Aulas 31 e 32 - Método com Parâmetro tipo Reference e This
* */

public class ProfessorTest {
    public static void main(String[] args) {
        Professor prof = new Professor();
        prof.cpf = "122.222.232-20";
        prof.matricula = "111122";
        prof.nome = "Marcos";
        prof.rg = "122211-5";

        Professor prof2 = new Professor();
        prof2.cpf = "122.777.656-68";
        prof2.matricula = "82710";
        prof2.nome = "Joana";
        prof2.rg = "122211-5";

        /*No exemplo abaixo a uma estrutura onde o código é repetido.
        Umas das premissas da OO é justamente evitar repetir o código.*/

       /* System.out.println(prof.cpf);
        System.out.println(prof.matricula);
        System.out.println(prof.nome);
        System.out.println(prof.rg);

        System.out.println(prof2.cpf);
        System.out.println(prof2.matricula);
        System.out.println(prof2.nome);
        System.out.println(prof2.rg);*/

        /*Utilizando o método imprime criado na Classe Professor.
        * Chamando o método imprime e passando para  a ele a referência do objeto
        * que é o endereço de memória onde está o objeto em referência.*/



//        System.out.println(prof.nome);
//        prof.imprime(prof);
//        prof.imprime(prof2);
        prof.imprime();
        prof2.imprime();
    }
}
