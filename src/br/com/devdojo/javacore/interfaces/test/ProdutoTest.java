package br.com.devdojo.javacore.interfaces.test;

import br.com.devdojo.javacore.interfaces.classes.Produto;

public class ProdutoTest {
    public static void main(String[] args) {
        Produto p = new Produto("Notebook", 4, 3000);
        p.calculaFrete();
        p.calcularImposto();
        System.out.println(p);

    }
}
