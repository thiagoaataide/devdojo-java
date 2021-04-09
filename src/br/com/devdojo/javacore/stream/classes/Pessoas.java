package br.com.devdojo.javacore.stream.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Pessoas {
   private String id;
   private String nome;
   private String nacionalidade;
   private int idade;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public Pessoas(String id, String nome, String nacionalidade, int idade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
    }

    public Pessoas(){

    }

    public List<Pessoas> popularPessoas(){
        Pessoas pessoa1 = new Pessoas("p1","Thiago","Brasil",31);
        Pessoas pessoa2 = new Pessoas("p2","Michele","Portuguesa",25);
        Pessoas pessoa3 = new Pessoas("p3","Gilvanete","Brasil",61);
        Pessoas pessoa4 = new Pessoas("p4","Carlos","Brasil",66);
        Pessoas pessoa5 = new Pessoas("p4","Carlos","Brasil",66);


        List pessoas = new ArrayList<Pessoas>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);
        pessoas.add(pessoa5);

        return pessoas;
    }

    public Collection<String> listaLetras(){
        Collection<String> list = Arrays.asList("A","B","A","C","B","D","E","D");
        return list;
    }

}
