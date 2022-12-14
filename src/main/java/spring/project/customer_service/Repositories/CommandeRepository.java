package spring.project.customer_service.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import spring.project.customer_service.Models.Commande;

@RepositoryRestResource
@CrossOrigin("*")
public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
