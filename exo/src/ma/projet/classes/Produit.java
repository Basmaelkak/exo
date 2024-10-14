/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/**
 *
 * @author pc
 */
@Entity
@Table(name = "produit")
 @NamedQuery(name= "findProduitByPrix",query = "from produit p where p.prix > 100")

public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "reference")
    private String ref;
    private float prix;
    @ManyToOne     //(fetch = FetchType.EAGER)
  //  @JoinColumn(name = "id")
   private Categorie categorie;
  //  @ManyToMany(mappedBy = "produit",fetch = FetchType.EAGER)
  //  List<Commande>commandes;

    public Produit() {
    }

    public Produit(String ref, float prix) {
        this.ref = ref;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

   
    
    
    
}
