package br.com.devdojo.javacore.modificadorestatico.test;

import br.com.devdojo.javacore.modificadorestatico.classes.Carro;

public class CarroTest {
    public static void main(String[] args) {
        Carro c1 = new Carro("BMW", 280);
        Carro c2 = new Carro("Audi", 275);
        Carro c3 = new Carro("Mercedes", 280);

        c1.imprime();
        c2.imprime();
        c3.imprime();

        /*Ao invés de alterar um atributo estático pela referência do objeto, dando a sensação que estar
        * sendo alterado apenas naquele objeto, o correto é chamar o atributo através de sua classe.*/
//        c1.setVelocidadeLimite(220);
//        Carro.velocidadeLimite = 220;

        /*Agora faremos o uso de métodos estáticos para atualizar o atributo estático, que nesse momento
        * é privado, e não mais público*/
        Carro.setVelocidadeLimite(210);
//        System.out.println(Carro.getVelocidadeLimite());

        c1.imprime();
        c2.imprime();
        c3.imprime();
    }
}
