package br.com.devdojo.javacore.io.test;

import java.io.File;
import java.io.IOException;

public class FileDiretorioTest {
    public static void main(String[] args) {
        File f = new File("folder");
        boolean mkdir = f.mkdir();
        System.out.println("Diretório criado? " + mkdir);


        /*Duas formas de criar arquivos em diretórios:
        * 1 - Passando o caminho absoluto
        * 2 - Passando em argumentos separados: Diretório + Nome_Arquivo*/
//        File arquivo = new File("C:\\Users\\Thiago Alberto\\workspaceSankhya\\projetos\\clientes\\devdojo\\folder\\Arquivo.txt");
        File arquivo = new File(f,"Arquivo2.txt");

        try {
            arquivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Arquivo Criado? " + arquivo);

        File arquivoNovoNome = new File(f,"arquivo_renomeado.txt");
        boolean renomeado = arquivo.renameTo(arquivoNovoNome);

        System.out.println("Renomeado? " + renomeado);

        //renomear diretorio

        File diretorioRnomeado = new File("folder2");
        boolean dirRenomeado = f.renameTo(diretorioRnomeado);
        System.out.println("Diretório Renomeado? " + dirRenomeado);

        buscarArquivo();


    }

    public static void buscarArquivo(){
        File buscar = new File("folder2");
        String[] list = buscar.list();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
