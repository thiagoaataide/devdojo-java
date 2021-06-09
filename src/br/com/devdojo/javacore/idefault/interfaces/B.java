package br.com.devdojo.javacore.idefault.interfaces;

public interface B {
    default void oi(){
        System.out.println("Oi dentro da Interface B");
    }
}
