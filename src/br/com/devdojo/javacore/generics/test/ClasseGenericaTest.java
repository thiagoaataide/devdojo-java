package br.com.devdojo.javacore.generics.test;

import br.com.devdojo.javacore.generics.classes.Carro;
import br.com.devdojo.javacore.generics.classes.Computador;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>();
        carrosDisponiveis.add(new Carro("Gol"));
        carrosDisponiveis.add(new Carro("BMW"));

        ObjetosAlugaveis<Carro> carroAlugavel = new ObjetosAlugaveis<>(carrosDisponiveis);
        Carro objetoDispovel = carroAlugavel.getObjetoDispovel();
        System.out.println("Após uso de 45 dias.");
        carroAlugavel.devolverObjeto(objetoDispovel);

        System.out.println("----------------------------------");

        List<Computador> comtadoresDisponiveis = new ArrayList<>();
        comtadoresDisponiveis.add(new Computador("Intel"));
        comtadoresDisponiveis.add(new Computador("AMD"));
        ObjetosAlugaveis<Computador> computadorObjetosAlugaveis = new ObjetosAlugaveis<>(comtadoresDisponiveis);
        Computador comp = computadorObjetosAlugaveis.getObjetoDispovel();
        System.out.println("Após utilização.");
        computadorObjetosAlugaveis.devolverObjeto(comp);

    }
}

//Type
class ObjetosAlugaveis<T>{
    private List<T> objetosDisponiveis = new ArrayList<>();

    public ObjetosAlugaveis(List<T> objetosDisponiveis){
        this.objetosDisponiveis = objetosDisponiveis;
    }


    //Alugar
    public T getObjetoDispovel(){
        T c = objetosDisponiveis.remove(0);
        System.out.println("Alugando Objeto: " + c);
        System.out.println("Objetos disponíveis: " + objetosDisponiveis);
        return c;
    }

    //devolvendo
    public void devolverObjeto(T c){
        System.out.println("Devolvendo Objeto: " + c);
        objetosDisponiveis.add(c);
        System.out.println("Objetos disponíveis: " + objetosDisponiveis);
    }

}
