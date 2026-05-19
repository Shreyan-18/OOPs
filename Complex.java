class Complex { //prog 14
    double real, imag;

    // Default Constructor
    Complex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    // Constructor for real numbers
    Complex(double real) {
        this.real = real;
        this.imag = 0.0;
    }

    // Constructor for complex numbers
    Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }
public Complex add(Complex other) {
    // This creates a new result without touching 'this' or 'other'
    double r = this.real + other.real;
    double i = this.imag + other.imag;
    return new Complex(r, i);
}
    public Complex multiply(Complex other) {
        double r = (this.real * other.real) - (this.imag * other.imag);
        double i = (this.real * other.imag) + (this.imag * other.real);
        return new Complex(r, i);
    }

    public static void main(String[] args) {
        Complex c1 = new Complex(3, 2);
        Complex c2 = new Complex(4, -3);
        
        // 1. Addition
        Complex c3 = c1.add(c2); 
        System.out.println("Add = " + c3.real + " + (" + c1.imag + "i)");

        // 2. Multiplication (Multiplying the result c3 with c2)
        Complex c4 = c3.multiply(c2);
        System.out.println("Multiply = " + c4.real + " + (" + c4.imag + "i)");
    }
}