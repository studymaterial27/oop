abstract class Car {
    public abstract void assembleParts();
    public abstract void paint();
    public abstract void allocateAccessories();
    public abstract void finalMakeup();

    public void buildCar() {
        assembleParts();
        paint();
        allocateAccessories();
        finalMakeup();
        System.out.println("Car building process completed.\n");
    }
}

class Hatchback extends Car {
    @Override
    public void assembleParts() {
        System.out.println("Assembling parts for Hatchback.");
    }
    @Override
    public void paint() {
        System.out.println("Painting Hatchback.");
    }
    @Override
    public void allocateAccessories() {
        System.out.println("Allocating accessories for Hatchback.");
    }
    @Override
    public void finalMakeup() {
        System.out.println("Final makeup for Hatchback.");
    }
}

class Sedan extends Car {
    @Override
    public void assembleParts() {
        System.out.println("Assembling parts for Sedan.");
    }
    @Override
    public void paint() {
        System.out.println("Painting Sedan.");
    }
    @Override
    public void allocateAccessories() {
        System.out.println("Allocating accessories for Sedan.");
    }
    @Override
    public void finalMakeup() {
        System.out.println("Final makeup for Sedan.");
    }
}

class SUV extends Car {
    @Override
    public void assembleParts() {
        System.out.println("Assembling parts for SUV.");
    }
    @Override
    public void paint() {
        System.out.println("Painting SUV.");
    }
    @Override
    public void allocateAccessories() {
        System.out.println("Allocating accessories for SUV.");
    }
    @Override
    public void finalMakeup() {
        System.out.println("Final makeup for SUV.");
    }
}

class CarFactory {
    public static Car createCar(String carType) {
        if (carType == null) {
            return null;
        }
        if (carType.equalsIgnoreCase("Hatchback")) {
            return new Hatchback();
        } else if (carType.equalsIgnoreCase("Sedan")) {
            return new Sedan();
        } else if (carType.equalsIgnoreCase("SUV")) {
            return new SUV();
        }
        return null;
    }
}

public class TestFactoryPattern {
    public static void main(String[] args) {
        Car hatchback = CarFactory.createCar("Hatchback");
        if (hatchback != null) {
            System.out.println("Building a Hatchback:");
            hatchback.buildCar();
        }
        Car sedan = CarFactory.createCar("Sedan");
        if (sedan != null) {
            System.out.println("Building a Sedan:");
            sedan.buildCar();
        }
        Car suv = CarFactory.createCar("SUV");
        if (suv != null) {
            System.out.println("Building an SUV:");
            suv.buildCar();
        }
    }
}
