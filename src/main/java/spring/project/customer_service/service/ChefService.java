package spring.project.customer_service.service;



import spring.project.customer_service.Models.Chef;
import spring.project.customer_service.Models.Commande;

import java.util.List;

public interface ChefService {
	Iterable<Chef> getAllChefs();
	Chef getChefById(long id);
	void deleteChefById(long id);
	Chef addChef(Chef chef);

	Commande saveCommande(String clinat_name, int pizza_factory, int restau, String chef_name);

}
