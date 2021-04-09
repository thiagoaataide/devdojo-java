package br.com.devdojo.patterns.singleton.teste;

import br.com.devdojo.patterns.singleton.classes.Aviao;
import br.com.devdojo.patterns.singleton.classes.AviaoSingletonEager;

public class AviaoSingletonEagerTest {
    public static void main(String[] args) {
        marcarAssento("1A");
        marcarAssento("1A");
    }

    public static void marcarAssento(String assento){
        AviaoSingletonEager a = AviaoSingletonEager.getInstance();
        System.out.println(a.bookAssento(assento));
    }


}
