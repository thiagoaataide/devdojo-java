package br.com.devdojo.javacore.classesinternas;

/**
 * Classes internas
 *
 * Anotações:
 * - Para ter uma classe interna, basta criar um classe dentro do escopo de outra classe.
 * - A Classe interna tem acesso a todos os atributos da classe externa.
 * - Para acessar a classe interna, primeiramente devemos ter um objeto da clase externa.
 * - Para utilização do this, o mesmo faz referência ao objeto da classe de onde está sendo chamado.
 *   Portanto, se o this está dentro da classe interna, fará referência ao objeto desta classe.
 * - Modificadores que pode ser utilizados na classe interna: public, protected, private, static, strictfp
 */
public class ClassesInternasTest {
    private String nome = "Thiago Alberto Ataide Silva";

    class Interna {
        public void verClasseExterna() {
            System.out.println(nome);
            System.out.println(this);
        }
    }

    public static void main(String[] args) {
        ClassesInternasTest extena = new ClassesInternasTest(); //criando objeto da class externa.
        ClassesInternasTest.Interna interna = extena.new Interna(); //criando objeto da classe interna.
        ClassesInternasTest.Interna interna2 = new ClassesInternasTest().new Interna(); //criando objeto da classe interna.
        interna.verClasseExterna(); //executando o método dentro da class interna.
        interna2.verClasseExterna(); //executando o método dentro da class interna.

    }
}

//class Externa {
//    private String nome = "Thiago Alberto Ataide Silva";
//
//    class Interna {
//     public void verClasseExterna(){
//         System.out.println(nome);
//     }
//    }
//}