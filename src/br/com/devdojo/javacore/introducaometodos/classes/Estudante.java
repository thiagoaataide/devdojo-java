package br.com.devdojo.javacore.introducaometodos.classes;

public class Estudante {
    private String nome;
    private int idade;
    private double[] notas;

    public double media;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade < 0) {
            System.out.println("Voce não pode fazer isso!");
            return;
        }
        this.idade = idade;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double caluloMedia(double[] notas) {
        double soma = 0d;
        for (double nota : notas) {
            soma += nota;
        }

        return   soma / notas.length;
    }

    public boolean statusEstudante(double media){
        return media > 6d;
    }

    public void imprime(double media){
        System.out.println("----------------------------");
        System.out.println("Nome: " +this.nome);
        System.out.println("Idade: " +this.idade);
        System.out.println("Nota 1: " + this.notas[0]);
        System.out.println("Nota 2: " + this.notas[1]);
        System.out.println("Nota 3: " + this.notas[2]);
        System.out.println("Média: " + media);
        if(statusEstudante(media)){
            System.out.println("Aprovado!");
        }else{
            System.out.println("Reprovado!");
        }
    }

}
