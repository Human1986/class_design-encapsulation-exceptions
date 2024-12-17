package jom.com.softserve.s1.task3;

class Product {
    private static int count;
    private String name;
    private double price;

    public Product() {
        count++;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        count++;
    }

    public static int count() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}