package spring.project.customer_service.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import spring.project.customer_service.Pizzeria.Pizzeria;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

@Entity
@Data @NoArgsConstructor @ToString @AllArgsConstructor
@Table(name = "chef")
public class Chef implements Observer , Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String name;
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Commande> commandes ;



    public Chef(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public Chef(String name, String password, Pizzeria pizzeria) {
        this.name = name;
        this.password = password;
        pizzeria.addObserver(this);
    }
    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("Vous devez préparer une pizza!");
    }
}
