package pers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class NotizkastenDao {

	private Session currentSession;
    
    private Transaction currentTransaction;
 
    public NotizkastenDao() {
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
 
    public void persist(Notizkasten entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Notizkasten entity) {
        getCurrentSession().update(entity);
    }
 
    public Notizkasten findById(long id) {
        Notizkasten notizK = (Notizkasten) getCurrentSession().get(Notizkasten.class, id);
        return notizK; 
    }
 
    public void delete(Notizkasten entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Notizkasten> findAll() {
        List<Notizkasten> kasten = (List<Notizkasten>) getCurrentSession().createQuery("from Notizkasten").list();
        return kasten;
    }
 
    public void deleteAll() {
        List<Notizkasten> entityList = findAll();
        for (Notizkasten entity : entityList) {
            delete(entity);
        }}
	
}
