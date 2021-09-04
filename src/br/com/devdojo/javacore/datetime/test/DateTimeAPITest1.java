package br.com.devdojo.javacore.datetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class DateTimeAPITest1 {
    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(Calendar.getInstance());

        /**
         * LocalDate
         *
         * */
        LocalDate date = LocalDate.of(2021, Month.SEPTEMBER, 2);
        System.out.println(date);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear()); //Ano Bissexto?
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));
        System.out.println(date.get(ChronoField.YEAR));

        LocalDate now = LocalDate.now();
        System.out.println(now);

        System.out.println("--------------LocalDateTime---------------");

        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);

        LocalTime time = LocalTime.of(22,2,15);
        System.out.println(time);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());

        System.out.println("------------------Parsing------------------------");
        LocalDate parseDate = LocalDate.parse("2017-07-17");
        LocalTime parseTime = LocalTime.parse("01:30:30");
        System.out.println(parseDate + " - " + parseTime);

        System.out.println("---------------LocalDateTime---------------------");

        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.of(2017,7,25,11,30,50);
        LocalDateTime ldt3 = date.atTime(10, 15, 10);
        LocalDateTime ltd4 = date.atTime(LocalTime.now());
        LocalDateTime ltd5 = time.atDate(date);

        System.out.println(ldt);
        System.out.println(ldt2);
        System.out.println(ldt3);
        System.out.println(ltd4);
        System.out.println(ltd5);
    }
}
