/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.classes;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author pc
 */
@Entity
public class LigneCommandeProduit implements Serializable {
    @EmbeddedId
    private CommandeProduitKey id;
    @ManyToOne
    @JoinColumn(name = "produit",insertable = false,updatable = false)
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "commande",insertable = false,updatable = false)
    private Commande commande;
    private int quantite;

    public LigneCommandeProduit() {
    }

    public LigneCommandeProduit(int quantite) {
        this.quantite = quantite;
    }

    public CommandeProduitKey getId() {
        return id;
    }

    public void setId(CommandeProduitKey id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

   
    
    
    
}
