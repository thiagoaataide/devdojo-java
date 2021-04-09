package br.com.devdojo.javacore.modificadorestatico.classes;

public class Carro {
    //Velocidade limite de ser de 240KM/h
    private String nome;
    private double velocidadeMaxima;
    private static double velocidadeLimite = 240;

    public Carro(String nome, double velocidadeMaxima) {
        this.nome = nome;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public Carro() {
    }

    public static void setVelocidadeLimite(double velocidadeLimite){
        Carro.velocidadeLimite = velocidadeLimite;
    }



    public static double getVelocidadeLimite(){
        return velocidadeLimite;
    }

    public void imprime() {
        System.out.println("----------------------------");
        System.out.println("Nome: " + this.nome);
        System.out.println("Velocidade Máxima: " + this.velocidadeMaxima);

        /* Como atributos estáticos não fazem parte do objeto,
         podemos acessa-los dentro da mesma classe apenas chamando pelo nome do mesmo*/
//        System.out.println("Velocidade Limite: " + this.velocidadeLimite);
        System.out.println("Velocidade Limite: " + velocidadeLimite);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }




}
