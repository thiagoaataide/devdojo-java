package br.com.devdojo.javacore.datetime.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITest3 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2017,7,17);
        System.out.println(localDate);

        //Alterando o ano de uma data específica.
        localDate.withYear(2020);
        //Importante que todos os atributos dessa API são Thread Safe. Por isso localDate permanece inalterado.
        System.out.println(localDate);

        //Pare verificar a nova data é preciso que criar uma variável.
        LocalDate localDate1 = localDate.withYear(2020);
        System.out.println(localDate1);

        LocalDate localDate2 = localDate.withMonth(Month.AUGUST.getValue());
        System.out.println(localDate2);

        LocalDate localDate3 = localDate.withDayOfMonth(20);
        System.out.println(localDate3);

        LocalDate with = localDate.with(ChronoField.DAY_OF_MONTH, 15);
        System.out.println(with);

        //Adicionar meses a uma data específica
        LocalDate localDate4 = localDate.plusMonths(3);
        System.out.println(localDate4);

        LocalDate plus = localDate.plus(2, ChronoUnit.MONTHS);
        System.out.println(plus);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime localTime = time.withHour(10);
        System.out.println(localTime);

        LocalTime localTime1 = time.plusHours(5);
        System.out.println(localTime1);
    }
}
