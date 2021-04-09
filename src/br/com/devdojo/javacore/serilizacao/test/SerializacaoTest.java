package br.com.devdojo.javacore.serilizacao.test;

import br.com.devdojo.javacore.serilizacao.classes.Aluno;
import br.com.devdojo.javacore.serilizacao.classes.Turma;

import java.io.*;

public class SerializacaoTest {
    public static void main(String[] args) {
        gravadorObjeto();
        leitorObjeto();
    }

    private static void gravadorObjeto() {
        Turma t = new Turma("Maratona Java");
        Aluno aluno = new Aluno(1L, "Thiago Alberto", "123456");
        aluno.setTurma(t);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aluno.ser"))) {

            oos.writeObject(aluno);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leitorObjeto() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aluno.ser"))) {

            Aluno aluno = (Aluno) ois.readObject();
            System.out.println(aluno);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
