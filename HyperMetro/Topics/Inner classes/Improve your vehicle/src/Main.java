class Vehicle {

    private final String name;

    Vehicle(String name) {
        this.name = name;
    }

    // create constructor

    class Engine {

        // add field horsePower
        // create constructor
        final int horsePower;

        Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        void start() {
            System.out.println("RRRrrrrrrr....");
        }

        // create method printHorsePower()
        void printHorsePower() {
            System.out.printf("Vehicle %s has %d horsepower.%n", name, horsePower);
        }
    }
}

// this code should work
class EnjoyVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Dixi");
        Vehicle.Engine engine = vehicle.new Engine(15);
        engine.printHorsePower();
    }
}
