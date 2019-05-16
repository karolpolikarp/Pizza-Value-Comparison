package com.kodilla.pizzaComparisonApp;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Pizza {
    int radius;
    double area;
    double circuit;
    double price;

    public Pizza(int diameter, double price) {
        this.radius = diameter / 2;
        this.price = price;
        this.area = PI * pow(radius, 2);
        this.circuit = 2 * PI * radius;
    }

    public double getCircuit() {
        return circuit;
    }

    public double getArea() {
        return area;
    }
    public double getPrice() {
        return price;
    }

}
