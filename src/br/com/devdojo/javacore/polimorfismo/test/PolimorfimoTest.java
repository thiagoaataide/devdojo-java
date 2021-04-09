package br.com.devdojo.javacore.polimorfismo.test;

import br.com.devdojo.javacore.polimorfismo.classes.Funcionario;
import br.com.devdojo.javacore.polimorfismo.classes.Gerente;
import br.com.devdojo.javacore.polimorfismo.classes.RelatorioPagamento;
import br.com.devdojo.javacore.polimorfismo.classes.Vendedor;

public class PolimorfimoTest {
    public static void main(String[] args) {
        Gerente g = new Gerente("Thiago Alberto", 6500, 2000);
        Vendedor v = new Vendedor("Michele Martins", 2000, 3000);
        RelatorioPagamento relatorio = new RelatorioPagamento();
//        relatorio.relatorioPagamentoGerente(g);
//        System.out.println("-----------------------------");
//        relatorio.relatorioPagamentoVendedor(v);

        relatorio.relatorioPagamentoGenerico(g);
        System.out.println("-----------------------------");
        relatorio.relatorioPagamentoGenerico(v);



    }
}
