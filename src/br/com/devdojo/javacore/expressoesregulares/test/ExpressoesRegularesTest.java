package br.com.devdojo.javacore.expressoesregulares.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressoesRegularesTest {
    public static void main(String[] args) {

//        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
//        String texto = "12 0x 0X 0xFFABC 0x10G 0x1";
//        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+"; // (\\w\\.])+@([a-zA-Z])+(\.([a-zA-Z])+)+
//        String texto = "fulano@hotmail.com, 102Abc@gmail.com, #@!abrao@mail.br, teste@gmail.com.br, teste@mail";
//        String regex = "\\d{2}/\\d{2}/\\d{2,4}";
//        String texto = "05/10/2010 05/05/2015 1/1/01 01/95/95"; // quero buscar por dd/MM/yyyy
        String regex = "proj([^,])*";
        String texto = "proj1.bkp, proj1.java, proj1.class, proj1final.java, proj3.java, diagrama, texto, foto"; // quero buscar por dd/MM/yyyy

        System.out.println("#@!abrao@mail.br".matches(regex));

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(texto);
        System.out.println("Texto:    " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("expressao: " + m.pattern());
        System.out.println("posicoes encontradas");
        while (m.find()) {
            System.out.println(m.start() + " - " + m.group());

        }

    }
}
