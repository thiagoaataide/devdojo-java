package br.com.devdojo.javacore.stream.classes;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class People {
    private String name;
    private int age;
    private double salary;
    private Genero genero;

    public People(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public People(String name, int age, double salary, Genero genero) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.genero = genero;
    }

    public static List<People> dbOfPeople() {
        return asList(
                new People("Thiago", 32, 2000, Genero.MASCULINO),
        new People("Mercy", 22, 3500, Genero.FEMININO),
        new People("Mercy", 22, 3500, Genero.FEMININO),
        new People("Ana", 17, 1895, Genero.FEMININO),
        new People("Thor", 23, 1980, Genero.MASCULINO),
        new People("Hulk", 35, 8000, Genero.MASCULINO),
        new People("Flash", 29, 3200, Genero.MASCULINO),
        new People("Batman", 37, 10000, Genero.MASCULINO),
        new People("Laterna Verde", 16, 5000, Genero.MASCULINO));
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

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }
}
