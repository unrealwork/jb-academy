package carsharing.model;

public class Customer {
    private final int id;
    private final String name;
    private final Integer rentedCarId;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.rentedCarId = null;
    }

    public Customer(int id, String name, int rentedCarId) {
        this.id = id;
        this.name = name;
        this.rentedCarId = rentedCarId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRentedCarId() {
        return rentedCarId;
    }
}
