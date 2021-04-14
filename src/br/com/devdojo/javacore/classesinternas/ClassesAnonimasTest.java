package br.com.devdojo.javacore.classesinternas;

import br.com.devdojo.javacore.generics.classes.Carro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classes Anonimas
 * <p>
 * - São classes definidas a partir de determinado ponto do código, que nãa tem um nome e que deixa de existir assim
 * que for utilizada.
 * <p>
 * - Não é possível criar novos métodos dentro da classe anônima, pois assim como no polimorfismo, temos uma variáevl
 * de referência de um dado objeto, e o comportamento que é executado é chamado pelo objeto, respeitando os métodos
 * existentes na classe. Se criarmos um método na classe anônima, ainda assim estamos usando a variável de referência
 * do objeto, onde esse comportamento não existe. Sendo assim, não é possível chamar o método declarado anonimamente.
 */

class Animal {
    public void andar() {
        System.out.println("Andando");
    }
}

public class ClassesAnonimasTest {
    public static void main(String[] args) {
        //criando a classe anonima.
        Animal a = new Animal() {
            public void andar() {
                System.out.println("Andando anonimamente");
            }
        };
        a.andar();

        List<Carro> carroList = new ArrayList<>();
        carroList.add(new Carro("BMW"));
        carroList.add(new Carro("Audio"));
//        Collections.sort(carroList, new CarroComparator());

        //outra forma de chamar a ordenação é chamar a classe anonima.
        Collections.sort(carroList, new Comparator<Carro>() {
            @Override
            public int compare(Carro o1, Carro o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

        System.out.println(carroList);

    }
}

class CarroComparator implements Comparator<Carro> {

    @Override
    public int compare(Carro o1, Carro o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}