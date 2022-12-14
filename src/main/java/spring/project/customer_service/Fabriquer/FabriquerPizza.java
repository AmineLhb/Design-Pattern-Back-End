package spring.project.customer_service.Fabriquer;

import spring.project.customer_service.Factory.PizzaFactory;

public interface FabriquerPizza {
    public PizzaFactory creerPizza(String type);
}
