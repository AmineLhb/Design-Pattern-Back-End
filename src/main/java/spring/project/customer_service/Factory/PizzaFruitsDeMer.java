package spring.project.customer_service.Factory;

public class PizzaFruitsDeMer extends PizzaFactory {

    public PizzaFruitsDeMer() {
        decription="Pizza aux fruits de mer";
        price=80;
    }

    @Override
    public void preparer() {
        System.out.println("Pizza Fruits de mer se prépare en 15min");
    }

    @Override
    public void emballer() {
        System.out.println("Emballage simple");
    }

    @Override
    public void couper() {
        System.out.println("Pizza Fruits de mer se découpe en 6 morceaux");
    }
}
