package org.book.servce;

import java.util.List;

import org.book.dao.AdminDao;
import org.book.entity.Admin;

public class AdminServce {
	//��ѯ����Ա
	public boolean queryAdmin(Admin admin) {
		return AdminDao.queryAdmin(admin);
	}
	
	//����Աע��
	public boolean addAdmin(Admin admin){
		if(!AdminDao.isExist(admin.getAname())){
			return AdminDao.addAdmin(admin);
		}else{
			return false;
		}
	}
	
	//��ѯ���й���Ա
	public List<Admin> queryAllAdmin(int currentPage, int pageSize){
		return AdminDao.queryAllAdmin(currentPage, pageSize);
	}
	
	//��ѯ����Ա����
	public int querySun(){
		return AdminDao.querySum();
	}
	
	//�޸Ĺ���Ա
	public boolean updateAdmin(Admin admin){
		return AdminDao.updateAdmin(admin);
	}
	
	//ɾ������Ա
	public boolean deleteAdmin(int id){
		return AdminDao.deleteAdmin(id);
	}
}
