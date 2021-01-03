package pers;

import java.util.List;

public class AdminService {

	private static AdminDao adminDao;
	 
    public AdminService() {
        adminDao = new AdminDao();
    }
 
    public void persist(Admin entity) {
        adminDao.openCurrentSessionwithTransaction();
        adminDao.persist(entity);
        adminDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Admin entity) {
        adminDao.openCurrentSessionwithTransaction();
        adminDao.update(entity);
        adminDao.closeCurrentSessionwithTransaction();
    }
 
    public Admin findById(long id) {
        adminDao.openCurrentSession();
        Admin admin = adminDao.findById(id);
        adminDao.closeCurrentSession();
        return admin;
    }
 
    public void delete(long id) {
        adminDao.openCurrentSessionwithTransaction();
        Admin admin = adminDao.findById(id);
        adminDao.delete(admin);
        adminDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Admin> findAll() {
        adminDao.openCurrentSession();
        List<Admin> admins = adminDao.findAll();
        adminDao.closeCurrentSession();
        return admins;
    }
 
    public void deleteAll() {
        adminDao.openCurrentSessionwithTransaction();
        adminDao.deleteAll();
        adminDao.closeCurrentSessionwithTransaction();
    }
 
    public AdminDao adminDao() {
        return adminDao;
    }
}


