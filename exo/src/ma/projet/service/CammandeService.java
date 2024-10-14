/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import ma.projet.classes.Commande;
import ma.projet.classes.Produit;
import ma.projet.idao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pc
 */
public class CammandeService implements IDao<Commande> {
     @Override
     public boolean create(Commande com) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(com);
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
    public boolean delete(Commande com) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(com);
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
    public boolean update(Commande com) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(com);
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
    public Commande findById(int id) {
        Session session = null;
        Commande com = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            com = (Commande) session.get(Commande.class, id);
            session.getTransaction().commit();
            return com;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return com;
    }

    @Override
    public List<Commande> findAll() {
        Session session = null;
        List<Commande>  commandes = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            commandes = session.createQuery("from commande").list();
            session.getTransaction().commit();
            return commandes;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return commandes;
    }
    
   public List<Produit> findProduitsEntreDates(Date dateDebut,Date dateFin){
       Session session=null;
       try{
           session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           //creer un critere
           Criteria criteria=session.createCriteria(Produit.class,"p");
           //joindre la table commende
           criteria.createAlias("p.commandes","c");
           criteria.add(Restrictions.between("c.dateCommande", dateDebut, dateFin));
           List<Produit> produits=criteria.list();
           return produits;
           
           
       }catch(HibernateException e){
           e.printStackTrace();
       }finally{
           if(session!=null){
           session.close();
       }
       
   } 
return Collections.emptyList();
   }
}
