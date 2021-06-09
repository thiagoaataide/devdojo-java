package br.com.devdojo.javacore.idefault.interfaces;

public interface MyList {
    /**
     * Com o Java 7 era possível apenas declarar interfaces com métodos totalmente abstratos.
     * Já com o Java 8, é possível criar métodos concretos dentro da interface; E comportamentos
     * estáticos.
     *
     * Para criar um método concreto, basta declarar o mesmo inciando com o modificado default.
     * Assim o Java irá entender que se trata de um método concreto, não será obrigatório a implementação
     * desse método em sub-classes que implementam a interface. E não há uma quebra de códigos legados.
     *
     * Classes Abstratas x Interfaces no Java 8
     *
     * Classe abstrata
     * - Pode ser estendida
     * - Implementar múltiplas interfaces
     * - Utilizar variáveis de instância.
     *
     * Interface
     * - Não pode utilizar variáveis de instâncias.
     * - Métodos opcionais, sobrescrever o método concreto, por exemplo.
     *
     * Novas Regras de Herança
     * 1. Uma classa sempre terá prioridade em relação as interfaces
     * 2. Em caso de situações com sub-interfaces, ou seja uma interface que estende a outra. O método de mesma
     *    assinatura mais específico será selecionado. Exemplo, a Classe C que implementa as interfaces A e B, mas B
     *    é filha de A, logo B é mais específica.
     * 3. Se a expressão for ambígua, onde a classe está herdando de múltiplas interface, é obrigatório explicitar
     *    qual método será sobrescrito.
     * */
    static void sort(){
        System.out.println("Comportamento estático dentro interface");
    }

    void add();

    default void remove(){
        System.out.println("Método concreto dentro da interface.");
    }
}
