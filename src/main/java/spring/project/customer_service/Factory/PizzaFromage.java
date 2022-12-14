package spring.project.customer_service.Factory;

public class PizzaFromage extends PizzaFactory {

    public PizzaFromage() {
        decription="Pizza au fromage";
        price=60;
    }

    @Override
    public void preparer() {
        System.out.println("Pizza Fromage se prépare en 8min");
    }

    @Override
    public void emballer() {
        System.out.println("Emballage simple");
    }

    @Override
    public void couper() {
        System.out.println("Pizza Fromage se découpe en 4 morceaux");
    }
}
