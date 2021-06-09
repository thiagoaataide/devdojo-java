package br.com.devdojo.javacore.idefault.interfaces;

public interface A {
    default void oi(){
        System.out.println("Oi dentro da Interface A");
    }
}
