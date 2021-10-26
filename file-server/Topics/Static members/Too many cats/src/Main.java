class Cat {
    private static int counter = 0;
    private final String name;
    private final int age;
    // write static and instance variables

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
        if (counter > 5) {
            System.out.println("You have too many cats");
        }
        // implement the constructor
        // do not forgot to check the number of cats
    }

    public static int getNumberOfCats() {
        // implement the static method
        return counter;
    }
}
