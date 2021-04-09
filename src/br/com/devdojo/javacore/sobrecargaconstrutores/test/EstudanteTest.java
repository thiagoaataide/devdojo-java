package br.com.devdojo.javacore.sobrecargaconstrutores.test;

import br.com.devdojo.javacore.sobrecargaconstrutores.classes.Estudante;

public class EstudanteTest {

    public static void main(String[] args) {
        Estudante est = new Estudante("1222211","Thiago", new double[]{7.0,8.5,9.0});
        est.imprime();
    }
}
