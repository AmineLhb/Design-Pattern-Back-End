package spring.project.customer_service.Adapter;

import spring.project.customer_service.Factory.PizzaFactory;

public class AdapterDollarImpl implements AdapterInterface{
    PizzaFactory pizzaFactory;

    public AdapterDollarImpl(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    @Override
    public double getNewPrice() {
        return pizzaFactory.getPrice()*0.095;
    }
}
