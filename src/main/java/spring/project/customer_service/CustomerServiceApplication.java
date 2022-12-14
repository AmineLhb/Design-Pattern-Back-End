package spring.project.customer_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.project.customer_service.Adapter.AdapterDollarImpl;
import spring.project.customer_service.Adapter.AdapterEuroImpl;
import spring.project.customer_service.Fabriquer.RestaurantFes;
import spring.project.customer_service.Fabriquer.RestaurantMeknes;
import spring.project.customer_service.Models.Chef;
import spring.project.customer_service.Models.Client;
import spring.project.customer_service.Factory.PizzaFactory;
import spring.project.customer_service.Pizzeria.Pizzeria;
import spring.project.customer_service.Repositories.ChefRepository;
import spring.project.customer_service.service.ChefService;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);

		Pizzeria pizzeria= new Pizzeria(new RestaurantFes());
		Client client1= new Client("Mohammed",pizzeria);
		Chef chef1= new Chef("Amine Lechheb","password",pizzeria);
		PizzaFactory p1= pizzeria.commanderPizza("fromage");
		System.out.println(client1.getName());
		System.out.println("-------------------");
		System.out.println("Le chef qui va préparer la pizza: "+chef1.getName());
		System.out.println("Description du pizza: "+p1.getDecription());
		System.out.println("Prix du pizza: "+p1.getPrice()+" Dhs");
		System.out.println("-------------------");
		AdapterEuroImpl adapterEuro = new AdapterEuroImpl(p1);
		System.out.println("The price in euro is "+adapterEuro.getNewPrice() +"€");
//		System.out.println("-------------------");
//		AdapterDollarImpl adapterDollar = new AdapterDollarImpl(p1);
//		System.out.println("The price in dollar is "+adapterDollar.getNewPrice() +"$");
//		System.out.println("-------------------");
//		System.out.println("-------------------");
//		System.out.println("-------------------\n");
//		Pizzeria pizzeria2= new Pizzeria(new RestaurantMeknes());
//		Client client2= new Client("Moad","location2",pizzeria2);
//		PizzaFactory p2= pizzeria2.commanderPizza("mixte");
//		System.out.println(client2.getName());
//		System.out.println(p2.getDecription());
//		System.out.println(p2.getPrice()+" Dhs");
//		System.out.println("-------------------");
//		AdapterEuroImpl adapterEuro2 = new AdapterEuroImpl(p2);
//		System.out.println("The price in euro is "+adapterEuro2.getNewPrice() +"€");
//		System.out.println("-------------------");
//		AdapterDollarImpl adapterDollar2 = new AdapterDollarImpl(p2);
//		System.out.println("The price in dollar is "+adapterDollar2.getNewPrice() +"$");

	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner start(ChefService chefService, ChefRepository chefRepository, RepositoryRestConfiguration restConfiguration){
//		return args -> {
//			restConfiguration.exposeIdsFor(Chef.class);
//			chefService.addChef(new Chef(null,"Amine Lechheb","password"));
//			chefService.addChef(new Chef(null,"Moad Aboutajedyne","password"));
//			chefService.addChef(new Chef(null,"Mohammed Bouzit","password"));
//			chefRepository.findAll().forEach(System.out::println);
//		};
//	}
//	@Bean
//	CommandLineRunner start(ChefService chefService, ChefRepository chefRepository, RepositoryRestConfiguration restConfiguration){
//		return args -> {
//			restConfiguration.exposeIdsFor(Chef.class);
//			Pizzeria pizzeria3=new Pizzeria(new RestaurantMeknes());
//			Chef chef1 = new Chef("Amine", "password", pizzeria3);
//			chefService.addChef(chef1);
//			PizzaFactory p1= pizzeria3.commanderPizza("fromage");
//			System.out.println("Le chef qui va préparer la pizza: "+chef1.getName());
//			chefRepository.findAll().forEach(System.out::println);
//		};
//	}

}
