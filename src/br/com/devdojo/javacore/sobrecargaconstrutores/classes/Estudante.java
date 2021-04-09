package br.com.devdojo.javacore.sobrecargaconstrutores.classes;
/*
 * Aulas:
 * 39 - Sobrecarga de Construtores pt 01
 * 40 - Sobrecarga de Construtores pt 02
 * */

public class Estudante {
    private String matricula;
    private String nome;
    private double[] notas;
    private String dataMatricula;

    public Estudante(String matricula, String nome, double[] notas){
        this.matricula = matricula;
        this.nome = nome;
        this.notas = notas;
    }
    public Estudante(String matricula, String nome, double[] notas,String dataMatricula){
        this(matricula,nome,notas);
        this.dataMatricula = dataMatricula;
    }

    public String getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(String dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Estudante(){

    }

    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.matricula);
        for (double nota : this.notas) {
            System.out.print(nota + " ");
        }

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }
}
