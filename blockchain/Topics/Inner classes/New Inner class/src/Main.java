class Vehicle {

    private String name;

    // create constructor

    public Vehicle(String name) {
        this.name = name;
    }

    class Engine {

        void start() {
            System.out.println("RRRrrrrrrr....");
        }

    }

    // create class Body
    class Body {
        final String color;

        Body(String color) {
            this.color = color;
        }

        void printColor() {
            System.out.printf("Vehicle %s has %s body.", name, color);
        }
    }
}

// this code should work
class EnjoyVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Dixi");
        Vehicle.Body body = vehicle.new Body("red");
        body.printColor();
    }
}
