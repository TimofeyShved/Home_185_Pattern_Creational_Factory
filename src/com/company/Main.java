package com.company;


public class Main {
    public static void main(String[] args) {
	    Factory factory = new Factory(); // объявим фабрику
        // создадим Toyota и UAZ, а так же вызывем метод drive
	    Car t = factory.create("Toyota");
        Car u = factory.create("UAZ");
        t.drive();
        u.drive();
    }
}

// Для создания патерна фабрики нужно:
// 1 - интерфейс класса
interface Car{
    void drive();
}

// 2 - наши создоваемые классы
class Toyota implements Car{
    @Override
    public void drive() {
        System.out.println("Drive Toyota");
    }
}

class UAZ implements Car{
    @Override
    public void drive() {
        System.out.println("Drive UAZ Patriot");
    }
}

// 3 - сама фабрика на которой по выбору можно создавать объекты
class Factory{
    public Car create(String typeCar){
        switch (typeCar){
            case "Toyota": return new Toyota();
            case "UAZ": return new UAZ();
            default: return null;
        }
    }
}