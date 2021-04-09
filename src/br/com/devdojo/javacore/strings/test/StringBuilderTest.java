package br.com.devdojo.javacore.strings.test;

public class StringBuilderTest {
    public static void main(String[] args) {
        String s = "Uma frase comum";
        StringBuilder sb = new StringBuilder(10);
        sb.append("Uma frase comum");
        sb.append(" Teste");
        System.out.println(sb);
//        System.out.println(sb.reverse()); //imprimir string invertida
//        System.out.println(sb.delete(0,2));
        System.out.println(sb.insert(2,"#####"));
    }
}
