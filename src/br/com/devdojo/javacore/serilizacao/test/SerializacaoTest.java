package br.com.devdojo.javacore.serilizacao.test;

import br.com.devdojo.javacore.serilizacao.classes.Aluno;
import br.com.devdojo.javacore.serilizacao.classes.Turma;

import java.io.*;

public class SerializacaoTest {


    public static void main(String[] args) {
        File arq = new File("serializacao","arquivo_serializado.ser");
        gravadorObjeto(arq);
        leitorObjeto(arq);
    }

    private static void gravadorObjeto(File arq) {

        Turma t = new Turma("Maratona Java");
        Aluno aluno = new Aluno(1L, "Thiago Alberto", "123456");
        aluno.setTurma(t);
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aluno.ser"))) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arq))) {

            oos.writeObject(aluno);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leitorObjeto(File arq) {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.ser"))) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arq))) {

            Aluno aluno = (Aluno) ois.readObject();
            System.out.println(aluno);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
