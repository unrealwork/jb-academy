class Person {

    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Patient extends Person {

    protected int height;

    public Patient(String name, int age, int height) {
        super(name, age);
        this.height = height;
    }
}