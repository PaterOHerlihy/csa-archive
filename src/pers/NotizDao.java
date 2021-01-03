package pers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class NotizDao {

	private Session currentSession;
    
    private Transaction currentTransaction;
 
    public NotizDao() {
    }
 
    public Session openCurrentSession() {
        currentSession = SessionFactoryHelper.getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = SessionFactoryHelper.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
 
    public void persist(Notiz entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Notiz entity) {
        getCurrentSession().update(entity);
    }
 
    public Notiz findById(long id) {
        Notiz notiz = (Notiz) getCurrentSession().get(Notiz.class, id);
        return notiz; 
    }
 
    public void delete(Notiz entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public ArrayList<Notiz> findAll() {
        ArrayList<Notiz> notizen = (ArrayList<Notiz>) getCurrentSession().createQuery("from Notiz").list();
        return notizen;
    }
 
    public void deleteAll() {
        List<Notiz> entityList = findAll();
        for (Notiz entity : entityList) {
            delete(entity);
        }}

}
