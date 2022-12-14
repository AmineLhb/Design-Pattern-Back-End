package spring.project.customer_service.Fabriquer;

import spring.project.customer_service.Factory.*;


public class RestaurantFes implements FabriquerPizza{
    @Override
    public PizzaFactory creerPizza(String type) {
        PizzaFactory p =null;
        if(type.equals("fromage")){
            p=new PizzaFromage();
        } else if (type.equals("fruits de mer")) {
            p=new PizzaFruitsDeMer();
        } else if (type.equals("quatre saisons")) {
            p=new PizzaQuatreSaisons();
        } else {

            p = new PizzaMixte();
        }
        System.out.println("Restaurant Fes");
        return p;

    }
}
