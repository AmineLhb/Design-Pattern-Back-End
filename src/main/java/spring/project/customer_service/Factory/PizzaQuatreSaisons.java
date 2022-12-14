package spring.project.customer_service.Factory;

public class PizzaQuatreSaisons extends PizzaFactory {
    public PizzaQuatreSaisons() {
        decription="Pizza quatre saisons";
        price=65;
    }

    @Override
    public void preparer() {
        System.out.println("Pizza Quatre Saisons se prépare en 10min");
    }

    @Override
    public void emballer() {
        System.out.println("Emballage simple");
    }

    @Override
    public void couper() {
        System.out.println("Pizza Quatre Saisons se découpe en 8 morceaux");
    }
}
