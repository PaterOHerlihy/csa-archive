package pers;

import java.util.ArrayList;
import java.util.List;

public class NotizService {

	private static NotizDao notizDao;
	 
    public NotizService() {
        notizDao = new NotizDao();
    }
 
    public void persist(Notiz entity) {
        notizDao.openCurrentSessionwithTransaction();
        notizDao.persist(entity);
        notizDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Notiz entity) {
        notizDao.openCurrentSessionwithTransaction();
        notizDao.update(entity);
        notizDao.closeCurrentSessionwithTransaction();
    }
 
    public Notiz findById(long id) {
        notizDao.openCurrentSession();
        Notiz notiz = notizDao.findById(id);
        notizDao.closeCurrentSession();
        return notiz;
    }
 
    public void delete(long id) {
        notizDao.openCurrentSessionwithTransaction();
        Notiz notiz = notizDao.findById(id);
        notizDao.delete(notiz);
        notizDao.closeCurrentSessionwithTransaction();
    }
 
    public ArrayList<Notiz> findAll() {
        notizDao.openCurrentSession();
        ArrayList<Notiz> notizen = notizDao.findAll();
        notizDao.closeCurrentSession();
        return notizen;
    }
 
    public void deleteAll() {
        notizDao.openCurrentSessionwithTransaction();
        notizDao.deleteAll();
        notizDao.closeCurrentSessionwithTransaction();
    }
 
    public NotizDao notizDao() {
        return notizDao;
    }
	
}
