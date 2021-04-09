package br.com.devdojo.javacore.sobrecargametodos.classes;

/*
* Aulas:
* 38 - Sobrecarga de Métodos
* 39 - Sobrecarga de Construtores pt 01
* 40 - Sobrecarga de Construtores pt 02
* */
public class Funcionario {
    private String nome;
    private String cpf;
    private double salario;
    private String rg;


    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    /*Aqui será utilizado o construtor ao invés do método init*/
    public Funcionario(String nome, String cpf, double salario, String rg){
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.rg = rg;
    }

    public Funcionario(){

    }


//    public void init(String nome, String cpf, double salario){
//        this.nome = nome;
//        this.cpf = cpf;
//        this.salario = salario;
//
//    }
//
//    public void init(String nome, String cpf, double salario,String rg){
////        this.nome = nome;
////        this.cpf = cpf;
////        this.salario = salario;
//        /*Da forma abaixo, a responsabilidade por setar as variáveis nome, cpf e salario
//        * ficam a cargo do método init com os três parâmetros. E reduz o código.*/
//        init(nome,cpf,salario);
//        this.rg = rg;
//    }

    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.cpf);
        System.out.println(this.salario);
        System.out.println(this.rg);
    }
}
