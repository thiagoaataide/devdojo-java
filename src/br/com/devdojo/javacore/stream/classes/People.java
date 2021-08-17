package br.com.devdojo.javacore.stream.classes;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class People {
    private String name;
    private int age;
    private double salary;

    public People(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public static List<People> dbOfPeople() {
        return asList(
                new People("Thiago", 32, 2000),
        new People("Mercy", 22, 3500),
        new People("Mercy", 22, 3500),
        new People("Ana", 19, 1895),
        new People("Thor", 23, 1980),
        new People("Hulk", 35, 8000),
        new People("Flash", 29, 3200),
        new People("Batman", 37, 10000000),
        new People("Laterna Verde", 24, 5000));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
