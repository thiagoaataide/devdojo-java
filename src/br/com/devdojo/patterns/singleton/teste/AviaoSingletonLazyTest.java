package br.com.devdojo.patterns.singleton.teste;
import br.com.devdojo.patterns.singleton.classes.AviaoSinglentonLazy;

public class AviaoSingletonLazyTest {
    public static void main(String[] args) {
        marcarAssento("1A");
        marcarAssento("1A");
    }

    public static void marcarAssento(String assento){
        AviaoSinglentonLazy a = AviaoSinglentonLazy.getInstance();
        System.out.println(a.bookAssento(assento));
    }
}
