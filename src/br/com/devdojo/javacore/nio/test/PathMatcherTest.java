package br.com.devdojo.javacore.nio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FindAllTest extends SimpleFileVisitor<Path>{
    /**
     * Buscar todos os arquivos de qualquer diretório a partir do Path, que tenha no nome a palavra "Test".
     * E que a extensão seja java ou class.
     */
    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Test}.{java,class}");
    private PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher("glob:**/*.{bkp}");
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(matcher.matches(file)){
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}

public class PathMatcherTest {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("pasta/subpasta/subsubpast/file.bkp");
        Path path2 = Paths.get("file.bkp");
        Path path3 = Paths.get("thiago");
        //sempre começar com o "glob:" no Pattern
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.bkp");
        System.out.println(matcher.matches(path1));
        System.out.println(matcher.matches(path2));
        System.out.println("-----------------------------------------");
        /*
        * Formas de localizar o path informado considerando ou não qualquer coisa que venha antes.
        * */
        matches(path1,"glob:*.bkp");
        matches(path1,"glob:**/*.bkp"); // com mais 2 asterícos e a barra podemos pegar qualquer coisa que venha antes do arquivo.
        matches(path1,"glob:*"); //qualquer coisa
        matches(path1,"glob:**.bkp"); // com mais 2 asterícos podemos pegar qualquer coisa que venha antes do arquivo.
        System.out.println("-----------------------------------------");
        /*
        * Validando se a extensão de três caracteres.
        * */
        matches(path1,"glob:*.???");
        matches(path1,"glob:**/*.???");
        matches(path1,"glob:**.???");
        System.out.println("-----------------------------------------");
        matches(path3,"glob:{thiago*,alberto*}"); //procurar arquivos com o nome thiago ou alberto
        matches(path3,"glob:{thiago,alberto}*"); //mesmo resultado do item acima
        matches(path3,"glob:{thiago,alberto}"); //aqui é um ou outro, ou contem thiago ou contém alberto.

        System.out.println("-----------------------------------------");
        Files.walkFileTree(Paths.get("./"), new FindAllTest());

    }

    private static void matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob+": " + matcher.matches(path));
    }
}
