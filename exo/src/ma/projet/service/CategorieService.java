/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.service;

import java.util.List;
import ma.projet.classes.Categorie;
import ma.projet.idao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author pc
 */
public class CategorieService implements IDao<Categorie> {
     @Override
     public boolean create(Categorie c) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(c);
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
    public boolean delete(Categorie c) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(c);
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
    public boolean update(Categorie c) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(c);
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
    public Categorie findById(int id) {
        Session session = null;
        Categorie c = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            c = (Categorie) session.get(Categorie.class, id);
            session.getTransaction().commit();
            return c;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return c;
    }

    @Override
    public List<Categorie> findAll() {
        Session session = null;
        List<Categorie>  categories = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            categories = session.createQuery("from categorie").list();
            session.getTransaction().commit();
            return categories;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        return categories;
    }
    
}
