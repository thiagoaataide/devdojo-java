package br.com.devdojo.javacore.colecoes.test;



import br.com.devdojo.javacore.serilizacao.classes.Aluno;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        //a lista não especifica qual tipos de seus componetes
        List nomes = new ArrayList();
        nomes.add("Thiago");
        nomes.add("Michele");
        nomes.add(new Aluno( 1L, "Thiago","htb93"));

        for (Object nome : nomes) {
            System.out.println(nome);
        }

        System.out.println("----------------------------------------------------");

        /*----------------------------------------------------------------------*/
        List<String> nomes2 = new ArrayList<>();
        nomes2.add("Thiago");
        nomes2.add("Michele");

        for (String s : nomes2) {
            System.out.println(s);
        }
    }
}
