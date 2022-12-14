package spring.project.customer_service.Factory;

public class PizzaMixte extends PizzaFactory {

    public PizzaMixte() {
        decription="Pizza Mixte";
        price=70;
    }

    @Override
    public void preparer() {
        System.out.println("Pizza Mixte se prépare en 13min");
    }

    @Override
    public void emballer() {
        System.out.println("Emballage simple");
    }

    @Override
    public void couper() {
        System.out.println("Pizza Mixte se découpe en 8 morceaux");
    }
}
