package com.company;

public class FactoryMethod {
    public static void main(String[] args) {
        Person person = Person.create();
    }
}

// Сам себя создаёт при вызыве
class Person{
    private Person(){}
    public static Person create(){
         return new Person();
    }
}