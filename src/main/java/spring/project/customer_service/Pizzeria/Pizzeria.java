package spring.project.customer_service.Pizzeria;
import spring.project.customer_service.Fabriquer.FabriquerPizza;
import spring.project.customer_service.Factory.PizzaFactory;
import java.util.Observable;
public class Pizzeria extends Observable {
    private FabriquerPizza fabrique;
    public Pizzeria(FabriquerPizza fabrique) {
        this.fabrique = fabrique;
    }
    public PizzaFactory commanderPizza(String type){
        setChanged();
        PizzaFactory p = fabrique.creerPizza(type);
        p.preparer();
        p.emballer();
        p.couper();
        notifyObservers();
        return p;
    }
}
