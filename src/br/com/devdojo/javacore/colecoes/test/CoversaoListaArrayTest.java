package br.com.devdojo.javacore.colecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoversaoListaArrayTest {
    public static void main(String[] args) {
        //Conversão de List em Array
        List<Integer> numerosLista = new ArrayList<>();
        numerosLista.add(2);
        numerosLista.add(0);
        numerosLista.add(4);
        numerosLista.add(3);
        numerosLista.add(8);

        Integer[] numerosArray = new Integer[numerosLista.size()];
        numerosLista.toArray(numerosArray);

        System.out.println(numerosLista);
        System.out.println(Arrays.toString(numerosArray));

        //Coversãode Array em List

        Integer[] numerosArray2 = new Integer[4];
        numerosArray2[0] = 2;
        numerosArray2[1] = 0;
        numerosArray2[2] = 4;
        numerosArray2[3] = 3;

        /**
         * O Arrays.asList ele faz uma ligação, pois os dados estão criados na tabela HEAP do sistema.
         * E são o mesmo objeto, no mesmo endereço de memória, o que for alterado em um, será alterado
         * no outro, pois ambos estão vinculados na memória.*/

        List<Integer> numeros2 = Arrays.asList(numerosArray2);
        List<Integer> numeros3 = new ArrayList<>();
        numeros3.addAll(Arrays.asList(numerosArray2));
        numeros2.set(0,1);//alterando o valor do indice 0, para valor 1

        System.out.println(Arrays.toString(numerosArray2));
        System.out.println(numeros2);
        System.out.println(numeros3);//não sofreu alteração, pois foi copiado antes
    }
}
