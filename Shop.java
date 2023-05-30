package miniproject01;

public class Shop extends Menu{
    double price;


    public Shop(String name, double price, String description) {
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
        return name + " " +price + " " + description;
    }
}
