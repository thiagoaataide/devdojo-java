package br.com.devdojo.javacore.exeception.runtimeexception.test;

public class RunTimeExceptionTest {
    public static void main(String[] args) {

        //Arithimetic exception
//        int a = 10 ;
//        int b =  0;
//        if(b != 0){
//            int c = a / b;
//            System.out.println(c);
//        }

        //NullPointerExcepetion
//        Object o = null;
//        System.out.println(o.toString());

        //ArrayIndexOutOfBoundsException
//        try{
//            int[] a = new int[2];
//            System.out.println(a[2]);
//            System.out.println("Dentro do bloco try");
//        }catch (ArrayIndexOutOfBoundsException e){
//            e.printStackTrace();
//        }
//        System.out.println("Sistema continua funcionando");
//
//    }

        divisao(10,0);
}

private static void divisao(int num1, int num2){
        if(num2 == 0){
            throw new IllegalArgumentException("Passe um valor diferente de 0 para o num2");
        }
    int result = num1/num2;
    System.out.println(result);
    }

}
