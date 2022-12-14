package spring.project.customer_service.serviceImpl;

import org.springframework.stereotype.Service;
import spring.project.customer_service.Fabriquer.RestaurantFes;
import spring.project.customer_service.Fabriquer.RestaurantMeknes;
import spring.project.customer_service.Factory.PizzaFactory;
import spring.project.customer_service.Models.Chef;
import spring.project.customer_service.Models.Client;
import spring.project.customer_service.Models.Commande;
import spring.project.customer_service.Pizzeria.Pizzeria;
import spring.project.customer_service.Repositories.ChefRepository;
import spring.project.customer_service.Repositories.ClientRepository;
import spring.project.customer_service.Repositories.CommandeRepository;
import spring.project.customer_service.service.ChefService;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Observable;
import java.util.Optional;


@Service
public class ChefServiceImpl implements ChefService  {
	private ChefRepository chefRepository;
	private PasswordEncoder passwordEncoder;
	private ClientRepository clientRepository;
	private CommandeRepository commandeRepository;

	public ChefServiceImpl(ChefRepository chefRepository,PasswordEncoder passwordEncoder,ClientRepository clientRepository,CommandeRepository commandeRepository) {
		this.passwordEncoder=passwordEncoder;
		this.chefRepository = chefRepository;
		this.clientRepository = clientRepository;
		this.commandeRepository = commandeRepository;
	}

	@Override
	public Iterable<Chef> getAllChefs() {
		return chefRepository.findAll();
	}
	@Override
	public Chef getChefById(long id) {
		Optional<Chef> optional = chefRepository.findById(id);
		Chef chef = null;
		if(optional.isPresent()) {
			chef = optional.get();
		}else {
			throw new RuntimeException("Chef not found for id :: "+id);
		}
		return chef;
	}

	public void deleteChefById(long id) {
		Optional<Chef> optional = chefRepository.findById(id);
		if(optional.isPresent()){
		this.chefRepository.deleteById(id);}
		else {
			throw new RuntimeException("Chef not found for id :: "+id);
		}
		
	}
	@Override
	public Chef addChef(Chef chef) {
		String pw=chef.getPassword();
		chef.setPassword(passwordEncoder.encode(pw));
		return chefRepository.save(chef);
	}

	@Override
	public Commande saveCommande(String clinat_name, int pizza_factory, int restau, String chef_name) {


		Chef chef = chefRepository.findChefByName(chef_name);
		Client client = new Client();
		client.setName(clinat_name);
		clientRepository.save(client);
		PizzaFactory pizzaFactory ;
		Commande commande= new Commande();
		commande.setChef(chef);


			commande.setClient(client);
		//Client client = clientRepository.FindClientByName(clinat_name);



		if(restau == 1){
			// fez
			RestaurantFes restaurantFes = new RestaurantFes();
			Pizzeria pizzeria = new Pizzeria(restaurantFes);

			if(pizza_factory == 1){

				pizzaFactory = pizzeria.commanderPizza("fromage");
				commande.setPrice(pizzaFactory.price);
				commande.setPlat(pizzaFactory.decription);


			}
			if(pizza_factory == 2){
				pizzaFactory = pizzeria.commanderPizza("fruits de mer");
				commande.setPrice(pizzaFactory.price);
				commande.setPlat(pizzaFactory.decription);

			}
			if(pizza_factory == 3){
				pizzaFactory = pizzeria.commanderPizza("mixte");
				commande.setPrice(pizzaFactory.price);
				commande.setPlat(pizzaFactory.decription);
			}
			if ( pizza_factory == 4) {
				pizzaFactory = pizzeria.commanderPizza("quatre saisons");
				commande.setPrice(pizzaFactory.price);
				commande.setPlat(pizzaFactory.decription);
			}

		}else{

			// meknes
			RestaurantMeknes restaurantMeknes = new RestaurantMeknes();
			Pizzeria pizzeria = new Pizzeria(restaurantMeknes);

			if(pizza_factory == 1){

				pizzaFactory = pizzeria.commanderPizza("fromage");
				commande.setPrice(pizzaFactory.price);
				commande.setPlat(pizzaFactory.decription);


			}
			if(pizza_factory == 2){
				pizzaFactory = pizzeria.commanderPizza("fruits de mer");
				commande.setPrice(pizzaFactory.price);
				commande.setPlat(pizzaFactory.decription);

			}
			if(pizza_factory == 3){
				pizzaFactory = pizzeria.commanderPizza("mixte");
				commande.setPrice(pizzaFactory.price);
				commande.setPlat(pizzaFactory.decription);
			}
			if(pizza_factory == 4) {
				pizzaFactory = pizzeria.commanderPizza("quatre saisons");
				commande.setPrice(pizzaFactory.price);
				commande.setPlat(pizzaFactory.decription);
			}




		}

		commandeRepository.save(commande);
		//System.out.println(commande);
	    client.getCommandes().add(commande);
		chef.getCommandes().add(commande);
		clientRepository.save(client);
		chefRepository.save(chef);
		return  commande;

		// Todo : save commande service

	}


}
