package br.com.devdojo.javacore.heranca.test;

import br.com.devdojo.javacore.heranca.classes.Endereco;
import br.com.devdojo.javacore.heranca.classes.Funcionario;
import br.com.devdojo.javacore.heranca.classes.Pessoa;

public class HerancaTest {
    public static void main(String[] args) {
        Pessoa p = new Pessoa("Michele Fernanda");
        Endereco e = new Endereco();

//        p.setNome("Michele Fernanda");
        p.setCpf("171.769.054-87");
        e.setRua("Rua da Muqueca");
        e.setBairro("Areia Branca");
        p.setEndereco(e);

        p.imprime();
        System.out.println("----------------------");

        Funcionario f = new Funcionario("Thiago Alberto");
        //herdados da classe Pessoa
//        f.setNome("Thiago Alberto");
        f.setCpf("083.388.654.19");
        f.setEndereco(e);

        f.setSalario(6500.00);
        f.imprime();




    }
}
