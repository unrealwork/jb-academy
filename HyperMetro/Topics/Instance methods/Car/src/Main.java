class Car {

    int yearModel;
    String make;
    int speed;

    void accelerate() {
        speed += 5;
    }

    void brake() {
        if (speed > 5) {
            speed -= 5;
        } else {
            speed = 0;
        }
    }
}
