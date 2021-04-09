package br.com.devdojo.patterns.singleton.teste;

import br.com.devdojo.patterns.singleton.classes.Aviao;

public class testAviao {
    public static void main(String[] args) {
        marcarAssento("1A");
        marcarAssento("1A");
    }

     public static void marcarAssento(String assento){
            Aviao a = new Aviao();
            System.out.println(a.bookAssento(assento));
        }

}
