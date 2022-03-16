class Complex {

    double real;
    double image;

    // write methods here
    
    void add(Complex o) {
        real += o.real;
        image += o.image;
    }
    
    void subtract(Complex o) {
        real -= o.real;
        image -= o.image;
    }
}
