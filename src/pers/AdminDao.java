package pers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDao {

private Session currentSession;
    
    private Transaction currentTransaction;
 
    public AdminDao() {
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
 
    public void persist(Admin entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Admin entity) {
        getCurrentSession().update(entity);
    }
 
    public Admin findById(long id) {
        Admin admin = (Admin) getCurrentSession().get(Admin.class, id);
        return admin; 
    }
 
    public void delete(Admin entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Admin> findAll() {
        List<Admin> admins = (List<Admin>) getCurrentSession().createQuery("from Admin").list();
        return admins;
    }
 
    public void deleteAll() {
        List<Admin> entityList = findAll();
        for (Admin entity : entityList) {
            delete(entity);
        }}
	
}
