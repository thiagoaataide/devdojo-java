package br.com.devdojo.javacore.introducaometodos.test;

import br.com.devdojo.javacore.introducaometodos.classes.Estudante;

public class EstudanteTest {
    public static void main(String[] args) {
        Estudante estudante = new Estudante();
        estudante.setNome("Thiago Alberto");
        estudante.setIdade(-1);
        estudante.setNotas(new double[]{5.6, 4.9, 7.2});
        double media = estudante.caluloMedia(estudante.getNotas());

        estudante.imprime(media);

    }
}
