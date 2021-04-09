package br.com.devdojo.javacore.classesabastratas.test;

import br.com.devdojo.javacore.classesabastratas.classes.Funcionario;
import br.com.devdojo.javacore.classesabastratas.classes.Gerente;
import br.com.devdojo.javacore.classesabastratas.classes.Vendedor;

public class FuncionarioTest {
    public static void main(String[] args) {
//        Funcionario f = new Funcionario("Marcos","20102-2",2000);
//        f.calculaSalario();
        Gerente g = new Gerente("Ana","20102-2",2000);
        g.calculaSalario();
        Vendedor v = new Vendedor("Marcos","20102-2",2000,10000);
        v.calculaSalario();
//        System.out.println(f.toString());
        System.out.println(g.toString());
        System.out.println(v.toString());
        System.out.println("----------------------");
        g.imprime();
        v.imprime();
    }
}
