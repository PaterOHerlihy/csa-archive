package pers;

import java.util.List;

public class KategorieService {

	private static KategorieDao kategorieDao;
	 
    public KategorieService() {
        kategorieDao = new KategorieDao();
    }
 
    protected void persist(Kategorie entity) {
        kategorieDao.openCurrentSessionwithTransaction();
        kategorieDao.persist(entity);
        kategorieDao.closeCurrentSessionwithTransaction();
    }
 
    protected void update(Kategorie entity) {
        kategorieDao.openCurrentSessionwithTransaction();
        kategorieDao.update(entity);
        kategorieDao.closeCurrentSessionwithTransaction();
    }
 
    public Kategorie findById(long id) {
        kategorieDao.openCurrentSession();
        Kategorie kateg = kategorieDao.findById(id);
        kategorieDao.closeCurrentSession();
        return kateg;
    }
 
    protected void delete(long id) {
        kategorieDao.openCurrentSessionwithTransaction();
        Kategorie kateg = kategorieDao.findById(id);
        kategorieDao.delete(kateg);
        kategorieDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Kategorie> findAll() {
        kategorieDao.openCurrentSession();
        List<Kategorie> kategorien = kategorieDao.findAll();
        kategorieDao.closeCurrentSession();
        return kategorien;
    }
 
    protected void deleteAll() {
        kategorieDao.openCurrentSessionwithTransaction();
        kategorieDao.deleteAll();
        kategorieDao.closeCurrentSessionwithTransaction();
    }
 
    public KategorieDao kategorieDao() {
        return kategorieDao;
    }
	
}
