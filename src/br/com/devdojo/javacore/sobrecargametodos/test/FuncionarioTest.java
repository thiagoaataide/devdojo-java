package br.com.devdojo.javacore.sobrecargametodos.test;

import br.com.devdojo.javacore.sobrecargametodos.classes.Funcionario;

public class FuncionarioTest {

    public static void main(String[] args) {
        /*Fazendo a inicialização dos atributos do objeto através do construtor*/
        Funcionario funcionario = new Funcionario("Thiago","111.222.333-44",4500,"123456");
        Funcionario funcionario2 = new Funcionario();

        /*Fazendo a inicialização dos atributos do objeto através de método*/
//        funcionario.init("Thiago","111.222.333-44",4500,"123456");
//        funcionario.setNome("Thiago");
//        funcionario.setCpf("111.222.333-44");
//        funcionario.setSalario(4500);
        funcionario.imprime();
        funcionario2.imprime();
    }
}
