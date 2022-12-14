package spring.project.customer_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.project.customer_service.Models.Chef;
import spring.project.customer_service.Models.Commande;
import spring.project.customer_service.Repositories.CommandeRepository;
import spring.project.customer_service.service.ChefService;

import java.util.Collection;
import java.util.List;


@RestController
@CrossOrigin("*")
public class ChefRestController {
	
	private final ChefService chefService;
	@Autowired
	private CommandeRepository commandeRepository;

	public ChefRestController(ChefService chefService) {
		this.chefService = chefService;
	}


	//display list of users
	@GetMapping("/chefs")
	@ResponseBody
	private Iterable<Chef> getChefs(){
		return chefService.getAllChefs();
	}


	//display users by id
	@GetMapping("/chefs/{id}")
	@ResponseBody
	public Chef getChef(@PathVariable("id") Long id) {
		return chefService.getChefById(id);
	}



	//update user
	@PutMapping("/showFormForUpdate/{id}")
	@ResponseBody
	public Chef showFormForUpdate(@PathVariable (value = "id") Long id, @RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
		Chef chef = chefService.getChefById(id);
		chef.setName(name);
		chef.setPassword(password);
		return chefService.addChef(chef);
	}

	//delete user by id
	@DeleteMapping("/deleteChef/{id}")
	@ResponseBody
	public void deleteChef(@PathVariable (value = "id") Long id) {
			this.chefService.deleteChefById(id);
	}


	@PostMapping("/save-commande")
	@ResponseBody
	public void saveCommande(@RequestParam("name") String name, @RequestParam(value = "pizza") int pizza, @RequestParam(value = "restau") int restau, @RequestParam(value = "chef") String chef_name) {
		System.out.println(name + "///"+pizza+"///"+ restau + "////");
		 chefService.saveCommande(name,pizza, restau, chef_name);

	}

	//register
	@PostMapping("/register")
	@ResponseBody
	public Chef saveNewChef(@RequestParam("name") String name,@RequestParam("pwd") String pwd) {
		Chef chef = new Chef();
		chef.setName(name);
		chef.setPassword(pwd);
		System.out.println(chef);
		return chefService.addChef(chef);
	}


}


