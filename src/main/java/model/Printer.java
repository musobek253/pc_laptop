package model;

public class Printer {
    private String maker;
    private String model;
    private int price;

    public Printer(String maker, String model, int price) {
        this.maker = maker;
        this.model = model;
        this.price = price;
    }

    public Printer() {
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "model.Printer{" +
                "maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
