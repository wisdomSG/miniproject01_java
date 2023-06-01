package miniproject01;

import java.util.Arrays;

public class Order extends Menu{

    double price;

    int count;

    public Order(String name, double price, int count, String description) {
        this.name = name;
        this.description = description;
        this.count = count;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() { return count;}

    public void setCount() {
        count += 1;
    }

    public String getDescription() {
        return description;
    }

    public String getAll() {
        return String.format("%-26s",name) + "| W "+String.format("%-8s",price) + "| " + count + "개 |" + description;
    }

    public static double totalPrice() {
        double sum = 0;
        for (Order num: orderList)
            sum = sum + num.getPrice()* num.getCount();
        return sum;
    }

    public static void listClear() {
        orderList.clear();
    }
}

