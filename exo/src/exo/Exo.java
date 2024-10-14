/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exo;

import java.util.Date;
import ma.projet.classes.Categorie;
import ma.projet.classes.Commande;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.classes.Produit;
import ma.projet.service.CammandeService;
import ma.projet.service.CategorieService;
import ma.projet.service.LigneCommadeProduitService;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Hibernate;

/**
 *
 * @author pc
 */
public class Exo {
     public static void main(String[] args){
      ProduitService p=new ProduitService();
     p.create(new Produit("ES12 ",120));
     p.create(new Produit("ZR85 ",100));
      p.create(new Produit("EE85",200));
     
      
        
    
        
        CammandeService c=new CammandeService();
        c.create(new Commande(new Date(12,02,2013)));
        c.create(new Commande(new Date(17,02,2013)));
        
        CategorieService cs=new CategorieService();
        cs.create(new Categorie("639","pain"));
        cs.create(new Categorie("421","cafe"));
        
        LigneCommadeProduitService lcp=new LigneCommadeProduitService();
        lcp.create(new LigneCommandeProduit(60));
        lcp.create(new LigneCommandeProduit(10));
        
        //affichage
       // p.ListeProduits();
      //  c.findProduitsEntreDates(new Date(),new Date());
        //  lcp.findProduitsCommande(1);

    /**
     * @param args the command line arguments
     */
   
        // TODO code application logic here
        HibernateUtil.getSessionFactory();
    }
    
}
