package br.com.devdojo.javacore.exeception.runtimeexception.test;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLException;

public class MultiplasRuntimeExcepetionTest {
    public static void main(String[] args) {
        try{
            throw new ArithmeticException();

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("dentro do ArrayIndexOutOfBoundsException");

        }catch (IllegalArgumentException e){
            System.out.println("dentro do IllegalArgumentException");

        }catch (ArithmeticException e){
            System.out.println("dentro do ArithmeticException");

        }catch (RuntimeException e){
            System.out.println("dentro do RuntimeException");
        }

        System.out.println("Final do programa!");

        //Java 6
        try{
            talvezLanceExcpetion();
        }catch (SQLException e){

        }catch (FileNotFoundException e){

        }

        //Java 7 - Multi-Catch
        try{
            talvezLanceExcpetion();
        }catch (SQLException | FileNotFoundException e){

        }
    }

    private static void talvezLanceExcpetion() throws SQLException, FileNotFoundException {

    }
}
