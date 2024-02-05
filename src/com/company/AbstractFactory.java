package com.company;

public class AbstractFactory {
    public static void main(String[] args) {
        // вызов создателя фабрик
        myFactory carfactory = new myAbstractFactory().createFactory("Car");
        myFactory tankFactory = new myAbstractFactory().createFactory("Tank");
        // фабрика для машин
        NewCar toyota = carfactory.createCar("Toyota");
        NewCar lada = carfactory.createCar("Lada");
        toyota.drive();
        lada.drive();
        // фабрика для танков
        NewTank is7 = tankFactory.createTank("IS7");
        NewTank t32 = tankFactory.createTank("T32");
        is7.drive();
        t32.drive();
    }
}


// 2 создания патерна
interface NewCar{
    void drive();
}
class Toyot implements NewCar{
    @Override
    public void drive() {
        System.out.println("Drive Toyota");
    }
}
class Lada implements NewCar{
    @Override
    public void drive() {
        System.out.println("Drive UAZ Patriot");
    }
}
class carFactory implements myFactory{
    public NewCar createCar(String typeCar){
        switch (typeCar){
            case "Toyota": return new Toyot();
            case "Lada": return new Lada();
            default: return null;
        }
    }

    @Override
    public NewTank createTank(String typeOfTank) {
        return null;
    }
}



interface NewTank{
    void drive();
}
class IS7 implements NewTank{
    @Override
    public void drive() {
        System.out.println("Drive IS7 in SSSR");
    }
}
class T32 implements NewTank{
    @Override
    public void drive() {
        System.out.println("Drive T32 in USA");
    }
}
class tankFactory implements myFactory{
    @Override
    public NewTank createTank(String typeTank){
        switch (typeTank){
            case "IS7": return new IS7();
            case "T32": return new T32();
            default: return null;
        }
    }

    @Override
    public NewCar createCar(String typeOfCar) {
        return null;
    }
}



// Интерфейс для создания фабрик
interface myFactory{
    NewCar createCar(String typeOfCar);
    NewTank createTank(String typeOfTank);
}

class myAbstractFactory {
    myFactory createFactory(String typeFactory){
        switch (typeFactory){
            case "Car": return new carFactory();
            case "Tank": return new tankFactory();
            default: return null;
        }
    }
}