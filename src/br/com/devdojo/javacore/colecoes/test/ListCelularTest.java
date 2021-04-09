package br.com.devdojo.javacore.colecoes.test;

import br.com.devdojo.javacore.colecoes.classes.Celular;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListCelularTest {
    public static void main(String[] args) {
        Celular c1 = new Celular("iPhone 6S", "123456");
        Celular c2 = new Celular("Galaxy S7", "456879");
        Celular c3 = new Celular("Nokia 1121", "67121");
        Celular c4 = new Celular("Sony Xperia", "123456");
        Celular c5 = new Celular("Asus Zenfone 5", "781231");//não incluído na lista
        List<Celular> celularList = new ArrayList<>();
        celularList.add(c1);
        celularList.add(c2);
        celularList.add(c3);
        celularList.add(c4);

        for (Celular celular : celularList) {
            System.out.println(celular);
            System.out.println(celular.getNome());
            System.out.println(celular.getIMEI());
        }


        System.out.println(c1 == c2); //false pois são objetos em endereços de memória distindos
        System.out.println(c1.equals(c4));//true pois dentro da classe Celular temos a sobrescrita do método, que compara o atributo IMEI
        System.out.println(celularList.contains(c3)); //testando se o objeto está na lista


        System.out.println("-----------------------------------------------------------------");
        /**
         * Parte fora do curso - testes com stream
         * */

        //outra forma de interar.
        celularList.forEach(System.out::println);

        //outra forma de fazer com stream
        List<String> collect = celularList.stream().map(Celular::getIMEI).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
