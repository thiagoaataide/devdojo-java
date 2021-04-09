package br.com.devdojo.javacore.io.test;

import java.io.Console;

public class ConsoleTest {
    public static void main(String[] args) {
        Console c = System.console();
        c.readPassword();
        char[] pw = c.readPassword("%s", "pw: ");
        for (char pass : pw) {
            c.format("%c ",pass);

        }
        c.format("\n");
    }
}
