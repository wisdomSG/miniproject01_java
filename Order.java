package miniproject01;

import java.util.Arrays;

public class Order extends Menu{

    double price;

    public Order(String name, double price, String description) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getAll() {
        return name + ", " +price + ", " + description;
    }

    public static double totalPrice() {
        double sum = 0;
        for (Order num: orderList)
            sum = sum + num.getPrice();
        return sum;
    }
}

