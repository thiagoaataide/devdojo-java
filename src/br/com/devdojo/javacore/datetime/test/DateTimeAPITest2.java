package br.com.devdojo.javacore.datetime.test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITest2 {
    public static void main(String[] args) {

        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(LocalDateTime.now());
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());
        //adicionado 3 segundos a 01/01/1970
        System.out.println(Instant.ofEpochSecond(3));
        //adicionado 3 segundos e ajustando nano segundos a 01/01/1970
        System.out.println(Instant.ofEpochSecond(3,0));
        System.out.println("----------------------DURATION--------------------------");

        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.of(2017,7,17,23,0,0);
        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.of(5,0,0);

        Duration d1 = Duration.between(dt1,dt2);
        Duration d2 = Duration.between(time1,time2);
        Duration d3 = Duration.between(Instant.now(),Instant.now().plusSeconds(1000));

        //Exceção porque não se pode misturar LocalDateTime com LocalTime
       // Duration d4 = Duration.between(dt2, time2);

        //Exceção porque não se pode utilizar LocalDate com o Duration, pois ele utiliza o tempo para calculo.
//        Duration d5 = Duration.between(LocalDate.now(), dt1);

        Duration d6 = Duration.between(dt2, time2.atDate(dt2.toLocalDate()));
        Duration d7 = Duration.of(3, ChronoUnit.MINUTES);
        Duration d8 = Duration.of(10, ChronoUnit.DAYS);

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d6);
        System.out.println(d7);
        System.out.println(d8);


        System.out.println("----------------------PERIOD--------------------------");

        Period p1 = Period.between(dt1.toLocalDate(),dt2.toLocalDate());
        Period p2 = Period.ofDays(10);
        Period p3 = Period.ofWeeks(58);
        Period p4 = Period.ofMonths(3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);

        System.out.println("----------------------CHRONOUNIT--------------------------");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nascimento = LocalDateTime.of(2017,7,17, 1,30,0);

        //Calculando a quantidade de dias, semana, meses ou ano entre duas datas.
        System.out.println(ChronoUnit.DAYS.between(nascimento,now));
        System.out.println(ChronoUnit.WEEKS.between(nascimento,now));
        System.out.println(ChronoUnit.MONTHS.between(nascimento,now));
        System.out.println(ChronoUnit.YEARS.between(nascimento,now));



    }
}
