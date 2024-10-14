/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.classes.Produit;
import ma.projet.idao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author pc
 */
public class ProduitService implements IDao<Produit> {
     @Override
      public boolean create(Produit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
    //        session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Produit o) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return false;
    }

    @Override
    public Produit findById(int id) {
        Session session = null;
        Produit e  = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e = (Produit) session.get(Produit.class, id);
            session.getTransaction().commit();
            return e;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return e;
    }

    @Override
    public List<Produit> findAll() {
        Session session = null;
        List<Produit>  produits = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            session.getTransaction().commit();
            return produits;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return produits;
    }

  public void ListeProduits(Categorie c){
     for(Produit p : c.getProd()){
                    System.out.println("La liste des produits est : "+p.getRef());
                }
     }
}

 //  public List<Produit> findProduitByCategorie(int id){
   //    Session session= null;
     //   try{
       //     session=HibernateUtil.getSessionFactory().openSession();
         //  session.beginTransaction();
           // Categorie categorie=(Categorie) session.get(Categorie.class, id);
            //if(categorie!=null){
              //  List <Produit> produits=  categorie.getProd();
                //return produits;
            //}
            //else
              //  return Collections.emptyList();
            
        //}catch(HibernateException e){
          //  e.printStackTrace();
        //}finally{
          //  if(session!=null)
            
            //    session.close();
        //}
         //return Collections.emptyList();
        
   //}
       //  @SuppressWarnings("unchecked")
        //@NamedQuery(name= "findProduitByPrix",query = "from produit p where p.prix > 100")
     //    public List<Produit> findProduitByPrix(){
    //   Session session =null;
      // List<Produit>produits=new ArrayList<>();
       //try{
         //  session=HibernateUtil.getSessionFactory().openSession();
           //session.beginTransaction();
           //produits=session.getNamedQuery("findProduitByPrix").list();
           //session.getTransaction().commit();
   //}catch(HibernateException e){
     //  e.printStackTrace();
   //}finally{
     //      if(session!=null){
       //        session.close();
         //  }
       //}
         //return Collections.emptyList();
  //       }
//}




    


