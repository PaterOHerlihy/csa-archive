package pers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class NutzerDao {

private Session currentSession;
    
    private Transaction currentTransaction;
 
    public NutzerDao() {
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
 
    public void persist(Nutzer entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Nutzer entity) {
        getCurrentSession().update(entity);
    }
 
    public Nutzer findById(long id) {
        Nutzer nutzer = (Nutzer) getCurrentSession().get(Nutzer.class, id);
        return nutzer; 
    }
 
    public void delete(Nutzer entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Nutzer> findAll() {
        List<Nutzer> nutzer = (List<Nutzer>) getCurrentSession().createQuery("from Nutzer").list();
        return nutzer;
    }
 
    public void deleteAll() {
        List<Nutzer> entityList = findAll();
        for (Nutzer entity : entityList) {
            delete(entity);
        }}
	
}
