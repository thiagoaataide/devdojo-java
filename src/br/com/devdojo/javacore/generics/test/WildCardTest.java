package br.com.devdojo.javacore.generics.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    abstract void consulta();
}

class Cachorro extends Animal {
    @Override
    void consulta() {
        System.out.println("Consultando Cachorro");
    }
}

class Gato extends Animal implements Comparable {
    @Override
    void consulta() {
        System.out.println("Consultando Gato");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

public class WildCardTest {
    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(),new Cachorro()};
        Gato[] gatos = {new Gato(),new Gato()};

//        consultarAnimais(cachorros); //polimorfismo
//        consultarAnimais(gatos); //polimorfismo

        List<Cachorro> cachorroList = new ArrayList<>();
        cachorroList.add(new Cachorro());
        cachorroList.add(new Cachorro());

        List<Gato> gatoList = new ArrayList<>();
        gatoList.add(new Gato());
        gatoList.add(new Gato());
        gatoList.add(new Gato());

        consultarAnimaisList(gatoList);
        consultarAnimaisList(cachorroList);

        List<Animal> animalList = new ArrayList<>();
        consultarAnimaisList(animalList);

        /**
         * Erro de compilação pois a classe Cachorro não implementa Comparable*/
//        ordenarLista(cachorroList);

        /**
         * Sem Erro de compilação pois a classe Gato implementa Comparable*/
        ordenarLista(gatoList);

    }

    public static void consultarAnimais(Animal[] animais) {
        for (Animal animal : animais) {
            animal.consulta();
        }
    }

//    public static void consultarAnimaisList(List<Animal> animais){ //Antes - erro de compilação se passar algum objeto que não for Animal, especificamente
    public static void consultarAnimaisList(List<? extends Animal> animais){ //depois - sem erro, passar qualquer lista que seja subclasse de animal. E prometo que não vou adicionar nada.
        for (Animal animal : animais) {
            animal.consulta();
        }
    }

    public static void consultarCachorros(List<? super Cachorro> cachorroList){
        Cachorro c1 = new Cachorro();
        Animal c2 = new Cachorro();
        Object o = new Cachorro();
        cachorroList.add(c1);//aqui é possivél add porque agora temos qualquer coisa que é um Cachorro ou super class de Cachorro.
    }

    //nunca é possível utilizar a palavra implements, mesmo que para interfaces. Sempre será apicado o extends
    public static void ordenarLista(List<? extends Comparable> lista){

    }
}
