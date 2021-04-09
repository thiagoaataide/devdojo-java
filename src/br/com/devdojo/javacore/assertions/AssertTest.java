package br.com.devdojo.javacore.assertions;

public class AssertTest {
    public static void main(String[] args) {
        calculaSalario(-2000);
    }

    private static void calculaSalario(double salario) {
        assert (salario > 0):"Salário nunca pode ser negativo " + salario;

//        if (salario > 0) {
//            //fazer o calculo com o salário
//        } else {
//            System.out.println("Se chegou aqui, ferrou");
//        }
    }
}
