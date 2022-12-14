package spring.project.customer_service.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.mapping.Collection;
import spring.project.customer_service.Pizzeria.Pizzeria;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "client")
public class Client implements Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    //private String location;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Commande> commandes =new ArrayList<Commande>();


    public Client(String name, Pizzeria pizzeria) {
        this.name = name;
        pizzeria.addObserver(this);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.print("Commande effectuée par le client :  ");
    }
}