package br.com.devdojo.javacore.classesinternas;

/**
 * Classes Internas Estáticas
 * */

class Externa{
    static class Interna{
        public void imprimir(){
            System.out.println("Oi");
        }
    }
}

public class ClassesInternasEstaticasTest {
    public static void main(String[] args) {
        Externa.Interna teste = new Externa.Interna();
        teste.imprimir();

        Interna2 teste2 = new Interna2();
        teste2.imprimir();
    }

    static class Interna2{
        public void imprimir(){
            System.out.println("Oi, dentro da interna 2");
        }
    }
}
