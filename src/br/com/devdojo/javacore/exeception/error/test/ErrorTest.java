package br.com.devdojo.javacore.exeception.error.test;

public class ErrorTest {
    public static void main(String[] args) {
        stackOverFlow();
    }

    public static void stackOverFlow(){
        stackOverFlow();
    }
}
