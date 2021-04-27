package br.com.devdojo.javacore.jdbc.test;

import br.com.devdojo.javacore.jdbc.classes.Comprador;
import br.com.devdojo.javacore.jdbc.db.CompradorDAO;

import java.util.List;
import java.util.Scanner;

public class CompradorCRUD {
    private static Scanner teclado = new Scanner(System.in);

    public static void executar(int op) {
        switch (op) {
            case 1:
                inserir();
                break;
            case 2:
                atualizar();
                break;
            case 3:
                listar();
                break;
            case 4:
                System.out.println("Digite o nome: ");
                listarPorNome(teclado.nextLine());
                break;
            case 5:
                deletar();
                break;
        }
    }

    private static void inserir() {
        Comprador c = new Comprador();
        System.out.println("Nome: ");
        c.setNome(teclado.nextLine());
        System.out.println("CPF: ");
        c.setCpf(teclado.nextLine());
        CompradorDAO.save(c);
    }

    private static void deletar() {
        System.out.println("Selecione um dos compradores abaixo: ");
        List<Comprador> compradorList = listar();
        Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Tem certeza? S/N");
        String op = teclado.nextLine();

        if (op.startsWith("s")) {
            CompradorDAO.delete(c);
        }
    }

    private static void atualizar() {
        System.out.println("Selecione um dos compradores abaixo: ");
        List<Comprador> compradorList = listar();
        Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
        System.out.println("Novo nome ou enter para manter o mesmo");
        String nome = teclado.nextLine();
        System.out.println("Novo CPF ou enter para manter o mesmo");
        String cpf = teclado.nextLine();

        if (!nome.isEmpty()) {
            c.setNome(nome);
        }

        if (!cpf.isEmpty()) {
            c.setNome(cpf);
        }

        CompradorDAO.update(c);
    }

    private static List<Comprador> listar() {
        List<Comprador> compradorList = CompradorDAO.selectAll();
        for (int i = 0; i < compradorList.size(); i++) {
            Comprador c = compradorList.get(i);
            System.out.println("[" + i + "] " + c.getCpf() + " - " + c.getNome());
        }

        return compradorList;
    }

    private static void listarPorNome(String nome) {
        List<Comprador> compradorList = CompradorDAO.searchByName(nome);
        for (int i = 0; i < compradorList.size(); i++) {
            Comprador c = compradorList.get(i);
            System.out.println("[" + i + "] " + c.getCpf() + " - " + c.getNome());
        }
    }

    public static List<Comprador> getLista(){
        return listar();
    }
}
