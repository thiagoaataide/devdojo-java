package br.com.devdojo.javacore.generics.test;

import br.com.devdojo.javacore.generics.classes.Carro;
import br.com.devdojo.javacore.generics.classes.Computador;

import java.util.ArrayList;
import java.util.List;

public class ClasseNaoGenericaTest {
    public static void main(String[] args) {
        CarroAlugavel carroAlugavel = new CarroAlugavel();
        Carro carroAlugado = carroAlugavel.getCarroDispovel();
        System.out.println("Usando o carro por um mês");
        carroAlugavel.devolverCarro(carroAlugado);

        System.out.println("-------------------------------------------------");

        ComputadorAlugavel pc = new ComputadorAlugavel();
        Computador computador = pc.getPcDispovel();
        System.out.println("Computador utilizado por 60 dias");
        pc.devolverPc(computador);

    }
}

class CarroAlugavel{
    private List<Carro> carrosDisponiveis = new ArrayList<>();

    {
        carrosDisponiveis.add(new Carro("Gol"));
        carrosDisponiveis.add(new Carro("BMW"));
    }

    //Alugar
    public Carro getCarroDispovel(){
        Carro c = carrosDisponiveis.remove(0);
        System.out.println("Alugando Carro: " + c);
        System.out.println("Carros disponíveis: " + carrosDisponiveis);
        return c;
    }

    //devolvendo
    public void devolverCarro(Carro c){
        System.out.println("Devolvendo Carro: " + c);
        carrosDisponiveis.add(c);
        System.out.println("Carros disponíveis: " + carrosDisponiveis);
    }

}


class ComputadorAlugavel{
    private List<Computador> computadoresDisponiveis = new ArrayList<>();

    {
        computadoresDisponiveis.add(new Computador("Intel"));
        computadoresDisponiveis.add(new Computador("AMD"));
    }

    //Alugar
    public Computador getPcDispovel(){
        Computador c = computadoresDisponiveis.remove(0);
        System.out.println("Alugando PC: " + c);
        System.out.println("PC's disponíveis: " + computadoresDisponiveis);
        return c;
    }

    //devolvendo
    public void devolverPc(Computador c){
        System.out.println("Devolvendo PC: " + c);
        computadoresDisponiveis.add(c);
        System.out.println("PC's disponíveis: " + computadoresDisponiveis);
    }

}

