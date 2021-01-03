package pers;

import java.util.List;

public class NutzerService {

	private static NutzerDao nutzerDao;

	public NutzerService() {
		nutzerDao = new NutzerDao();
	}

	public void persist(Nutzer entity) {
		nutzerDao.openCurrentSessionwithTransaction();
		nutzerDao.persist(entity);
		nutzerDao.closeCurrentSessionwithTransaction();
	}

	public void update(Nutzer entity) {
		nutzerDao.openCurrentSessionwithTransaction();
		nutzerDao.update(entity);
		nutzerDao.closeCurrentSessionwithTransaction();
	}

	public Nutzer findById(long id) {
		nutzerDao.openCurrentSession();
		Nutzer nutzer = nutzerDao.findById(id);
		nutzerDao.closeCurrentSession();
		return nutzer;
	}

	public void delete(long id) {
		nutzerDao.openCurrentSessionwithTransaction();
		Nutzer nutzer = nutzerDao.findById(id);
		nutzerDao.delete(nutzer);
		nutzerDao.closeCurrentSessionwithTransaction();
	}

	public List<Nutzer> findAll() {
		nutzerDao.openCurrentSession();
		List<Nutzer> nutzer = nutzerDao.findAll();
		nutzerDao.closeCurrentSession();
		return nutzer;
	}

	public void deleteAll() {
		nutzerDao.openCurrentSessionwithTransaction();
		nutzerDao.deleteAll();
		nutzerDao.closeCurrentSessionwithTransaction();
	}

	public NutzerDao nutzerDao() {
		return nutzerDao;
	}

}
