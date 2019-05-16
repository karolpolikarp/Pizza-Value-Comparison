package com.kodilla.pizzaComparisonApp;

import static java.lang.Math.round;

public class PizzaComparisonLogic{

    public String comparePizzas(Pizza pizza1, Pizza pizza2, double qty1, double qty2) {

        double areaQty1 = round(pizza1.getArea() * qty1);
        double areaQty2 = round(pizza2.getArea() * qty2);

        if (areaQty1 > areaQty2) {
            return "Pizza A's area = " + areaQty1 + "cm\u00B2"
                    + "\n" + "Crust length = " + round(pizza1.getCircuit()) + "cm"
                    + "\n" + "Cm\u00B2 per price = " + round(CmPerZl(pizza1)) + "cm\u00B2/zl"
                    + "\n" + "Pizza B's area = " + areaQty2 + "cm\u00B2"
                    + "\n" + "Pizza B's cm\u00B2 per price = " + round(CmPerZl(pizza2) * qty1) + "cm\u00B2/zl";
        } else if (areaQty1 < areaQty2) {
            return "Pizza B's area = " + areaQty2 + "cm\u00B2"
                    + "\n" + "Crust length = " + round(pizza2.getCircuit()) + "cm"
                    + "\n" + "Cm\u00B2 per price = " + round(CmPerZl(pizza2)) + "cm\u00B2/zl"
                    + "\n" + "Pizza A's area = " + areaQty1 + "cm\u00B2"
                    + "\n" + "Pizza A's cm\u00B2 per price = " + round(CmPerZl(pizza1) * qty1) + "cm\u00B2/zl";
        } else {
            return null;
        }
    }

    public String dealPizzas(Pizza pizza1, Pizza pizza2, double qty1, double qty2) {

        double areaQty1 = round(pizza1.getArea() * qty1);
        double areaQty2 = round(pizza2.getArea() * qty2);

        if (areaQty1 > areaQty2) {
            return "Pizza A is a " + percentageAreaComparison(pizza1, pizza2, qty1, qty2) + "%" + " better deal!";
        } else if (areaQty1 < areaQty2) {
            return "Pizza B is a " + percentageAreaComparison(pizza1, pizza2, qty1, qty2) + "%" + " better deal!";
        } else {
            return "Pizzas are the same deal!";
        }
    }


    private double CmPerZl(Pizza pizza) {
        return (pizza.getArea() / pizza.getPrice());
    }

    private int percentageAreaComparison(Pizza pizza1, Pizza pizza2, double qty1, double qty2) {

        double areaQty1 = round(pizza1.getArea() * qty1);
        double areaQty2 = round(pizza2.getArea() * qty2);

        double price1PerCm = round(areaQty1 / pizza1.getPrice());
        double price2PerCm = round(areaQty2 / pizza2.getPrice());

        if (price1PerCm > price2PerCm) {
            return (int)round(price1PerCm * 100 / price2PerCm) - 100;
        } else {
            return (int)round(price2PerCm * 100 / price1PerCm) - 100;
        }
    }
}
