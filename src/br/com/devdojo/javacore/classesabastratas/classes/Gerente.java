package br.com.devdojo.javacore.classesabastratas.classes;

public class Gerente extends Funcionario{
    public Gerente(String nome, String clt, double salario) {
        super(nome, clt, salario);
    }

    @Override
    public void imprime() {

    }

    @Override
    public void calculaSalario() {
        this.salario = salario + (salario * 0.2);
    }
}
