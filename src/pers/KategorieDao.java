package pers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class KategorieDao {

private Session currentSession;
    
    private Transaction currentTransaction;
 
    public KategorieDao() {
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
 
    public void persist(Kategorie entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Kategorie entity) {
        getCurrentSession().update(entity);
    }
 
    public Kategorie findById(long id) {
        Kategorie kateg = (Kategorie) getCurrentSession().get(Kategorie.class, id);
        return kateg; 
    }
 
    public void delete(Kategorie entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Kategorie> findAll() {
        List<Kategorie> kategorien = (List<Kategorie>) getCurrentSession().createQuery("from Kategorie").list();
        return kategorien;
    }
 
    public void deleteAll() {
        List<Kategorie> entityList = findAll();
        for (Kategorie entity : entityList) {
            delete(entity);
        }}
	
}
