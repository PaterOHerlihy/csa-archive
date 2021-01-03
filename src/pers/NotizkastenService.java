package pers;

import java.util.List;

public class NotizkastenService {

	private static NotizkastenDao notizkastenDao;

	public NotizkastenService() {
		notizkastenDao = new NotizkastenDao();
	}

	public void persist(Notizkasten entity) {
		notizkastenDao.openCurrentSessionwithTransaction();
		notizkastenDao.persist(entity);
		notizkastenDao.closeCurrentSessionwithTransaction();
	}

	public void update(Notizkasten entity) {
		notizkastenDao.openCurrentSessionwithTransaction();
		notizkastenDao.update(entity);
		notizkastenDao.closeCurrentSessionwithTransaction();
	}

	public Notizkasten findById(long id) {
		notizkastenDao.openCurrentSession();
		Notizkasten notizkasten = notizkastenDao.findById(id);
		notizkastenDao.closeCurrentSession();
		return notizkasten;
	}

	public void delete(long id) {
		notizkastenDao.openCurrentSessionwithTransaction();
		Notizkasten nk = notizkastenDao.findById(id);
		notizkastenDao.delete(nk);
		notizkastenDao.closeCurrentSessionwithTransaction();
	}

	public List<Notizkasten> findAll() {
		notizkastenDao.openCurrentSession();
		List<Notizkasten> nks = notizkastenDao.findAll();
		notizkastenDao.closeCurrentSession();
		return nks;
	}

	public void deleteAll() {
		notizkastenDao.openCurrentSessionwithTransaction();
		notizkastenDao.deleteAll();
		notizkastenDao.closeCurrentSessionwithTransaction();
	}

	public NotizkastenDao notizkastenDao() {
		return notizkastenDao;
	}

}
