package br.com.devdojo.javacore.jdbc.test;

import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.db.CompradorDAO;

import java.util.List;
import java.util.Scanner;

public class TesteCRUD {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true) {
            menu();
            op = Integer.parseInt(teclado.nextLine());
            if (op == 0) {
                System.out.println("Saindo do Sistema");
                break;
            }

            if (op == 1) {
                menuComprador();
                op = Integer.parseInt(teclado.nextLine());
                CompradorCRUD.executar(op);
            }

            if (op == 2) {
                menuCarro();
                op = Integer.parseInt(teclado.nextLine());
                CarroCRUD.executar(op);
            }
        }
    }

    private static void menu() {
        System.out.println("Selecione uma opção: ");
        System.out.println("1. Comprador");
        System.out.println("2. Carro");
        System.out.println("0. Sair");
    }


    private static void menuComprador() {
        System.out.println("Digitie a opção para começar");
        System.out.println("1. Inserir comprador");
        System.out.println("2. Atualizar comprador");
        System.out.println("3. Listar todos os compradores");
        System.out.println("4. Buscar comprador por nome");
        System.out.println("5. Deletar Comprador");
        System.out.println("9. Voltar");
    }

    private static void menuCarro() {
        System.out.println("Digitie a opção para começar");
        System.out.println("1. Inserir Carro");
        System.out.println("2. Atualizar Carro");
        System.out.println("3. Listar todos os Carros");
        System.out.println("4. Buscar Carro por nome");
        System.out.println("5. Deletar Carro");
        System.out.println("9. Voltar");
    }
}
