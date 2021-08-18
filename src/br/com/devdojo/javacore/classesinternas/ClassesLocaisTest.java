package br.com.devdojo.javacore.classesinternas;

/**
 * Classes Locais
 * <p>
 * Anotações:
 * <p>
 * - Mesmo declarando uma classe interna dentro de um método, ainda é possível acessar todos os atributos
 * da classe externa.
 * - Não é possível ter acesso a uma classe local dentro de um método, uma vez que não estamos dentro
 *   do método.
 * - Como precisamos de um objeto da classe interna para chamar o método da mesma, e não temos acesso a
 *   essa classe interna fora do método local, é necessário criar fora da classe interna e dentro do método,
 *   o objeto e a chamada ao método interno.
 *
 * - Para as classes dentro de métodos locais, só é possível utilizar dois modificadores: abstract e final
 *
 *  Diferenças entre Java 7 e 8
 *
 *  - Na declaração de um atributo dentro do método local, para o Java 7, o atributo deve ser declarado como o
 *    modificador "final"; Isso porque os atributos de um método deixam de existir na tabela HEAP após a sua execução.
 *    No entanto, para a classe interna, o atributo pode ainda ser necessário e se acionado não existiria mais em memória.
 *    Então se precisarmos criar atributos locais para o método, é preciso explicitar que o mesmo é final.
 *
 *    No Java 8, houve uma mudança nessa regra, não é necessário explicitar o modificador final, pois o atributo declarado é
 *    considerado efetivamente final. No entanto, se houver a necessidade de modificar o valor do atributo teremos um
 *    erro de compilação.
 */

public class ClassesLocaisTest {
    private String nome = "Thiago";

    public void fazAlgumaCoisa() {
//        String sobrenome = "Alberto";
        /**
         * A linha abaixo resultaria em erro, pois como descrito acima, no Java 8 um atributo de métodos que
         * contenham uma classe interna precisam ser final ou efetivamente final. E por consequência não podem
         * sofrer alterações.
         * */
//        sobrenome = "outro nome";
        class Interna {

            public void imprimeNomeExterno() {
                System.out.println(nome);
            }
        }

        Interna in = new Interna();
        in.imprimeNomeExterno();

    }

    public static void main(String[] args) {
        ClassesLocaisTest externa = new ClassesLocaisTest();
        externa.fazAlgumaCoisa();
    }
}
