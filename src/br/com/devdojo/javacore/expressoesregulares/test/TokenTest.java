package br.com.devdojo.javacore.expressoesregulares.test;

public class TokenTest {
    public static void main(String[] args) {

        String str = "William, Thiago, Michele, Miguel, Gilvanete, Neury";
        String[] tokens = str.split(",");
        for (String token : tokens) {
            System.out.println(token.trim());
        }


    }
}
