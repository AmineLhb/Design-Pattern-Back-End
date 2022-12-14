package spring.project.customer_service.Factory;

public abstract class PizzaFactory {
    public String decription;
    public double price;
    public abstract void preparer();
    public abstract void emballer();
    public abstract void couper();

    public String getDecription() {
        return decription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }


}
