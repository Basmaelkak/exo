/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.Collections;
import static java.util.Collections.list;
import java.util.List;
import ma.projet.classes.LigneCommandeProduit;
import ma.projet.idao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author pc
 */
public class LigneCommadeProduitService implements IDao<LigneCommandeProduit>{
     @Override
     public boolean create(LigneCommandeProduit cp) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cp);
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
    public boolean delete(LigneCommandeProduit cp) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cp);
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
    public boolean update(LigneCommandeProduit cp) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cp);
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
    public LigneCommandeProduit findById(int id) {
        Session session = null;
        LigneCommandeProduit cp = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            cp = (LigneCommandeProduit) session.get(LigneCommandeProduit.class, id);
            session.getTransaction().commit();
            return cp;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return cp;
    }

    @Override
    public List<LigneCommandeProduit> findAll() {
        Session session = null;
        List<LigneCommandeProduit>  commandes = null;
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
    
    public List <LigneCommandeProduit> findProduitsCommande(int id){
        Session session =null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
         
   String hql="select p.reference,p.prix,lcp.quantite"+"from lignecommandeproduit lcp"+ "join lcp.produit p"+"where lcp.commande.id=:idCommande";
   Query query= session.createQuery(hql);
   query.setParameter("idCommande", id);
   List<LigneCommandeProduit> result=query.list();
   session.getTransaction().commit();
   return result;
           
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
