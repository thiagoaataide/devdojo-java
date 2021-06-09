package br.com.devdojo.javacore.idefault.classes;

import br.com.devdojo.javacore.idefault.interfaces.A;
import br.com.devdojo.javacore.idefault.interfaces.B;
import br.com.devdojo.javacore.idefault.interfaces.D;

/**
 * Regra 1
 * Interface A
 * Interface B, estende A
 * Classe C, estende D,  implementa A, B
 * Classe D implementa A, B
 *
 * Nesse exemplo temos um objeto da classe C que aciona o método oi() presente em todas as classes e interfaces,
 * como as classes implementam exatamente as mesmas interface, o método que terá preferência será sempre o da classe
 * mais específica, no caso a Classe D.
 *
 * */

/**
 * Regra 2
 *   Interface A
 *   Interface B estende A
 *   Classe C, implementa A, B
 *
 *   Neste exemplo ao acionar o método oi() através da classe C, será acionado o método da classe mais específica.
 *   Como B é filha de A, e portanto B é, de fato, A. O método chamado será da interface B.
 **/

/**
 * Regra 3
 *   Interface A
 *   Interface B
 *   Classe C, implementa A, B
 *
 *   Neste exemplo teremos um erro de compilação pois não é possível que o objeto da classe C determine qual será o
 *   método oi() a ser chamado. Para isso é preciso implementar o método oi() dentro da classe C, e especificar de
 *   qual classe invocar o método.
 * */
public class C implements A, B {
    public static void main(String[] args) {
        new C().oi();
    }

    public void oi(){
        A.super.oi();
    }
}
