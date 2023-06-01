package miniproject01;

public class Manager extends  Menu{
    double price;
    int count;


    public Manager(String name, double price, int count,String description) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public int getCount() {
        return count;
    }
    public String getDescription() {
        return description;
    }

    public String getAll() {
        return String.format("%-26s",name) + " | " +price + " | " + description;
    }

    public static double totalPrice() {
        double sum = 0;
        for (Order num: orderList)
            sum = sum + num.getPrice()*num.getCount();
        return sum;
    }
}
