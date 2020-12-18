package org.book.servce;

import java.util.List;

import org.book.dao.AdminDao;
import org.book.entity.Admin;

public class AdminServce {
	//查询管理员
	public boolean queryAdmin(Admin admin) {
		return AdminDao.queryAdmin(admin);
	}
	
	//管理员注册
	public boolean addAdmin(Admin admin){
		if(!AdminDao.isExist(admin.getAname())){
			return AdminDao.addAdmin(admin);
		}else{
			return false;
		}
	}
	
	//查询所有管理员
	public List<Admin> queryAllAdmin(int currentPage, int pageSize){
		return AdminDao.queryAllAdmin(currentPage, pageSize);
	}
	
	//查询管理员总数
	public int querySun(){
		return AdminDao.querySum();
	}
	
	//修改管理员
	public boolean updateAdmin(Admin admin){
		return AdminDao.updateAdmin(admin);
	}
	
	//删除管理员
	public boolean deleteAdmin(int id){
		return AdminDao.deleteAdmin(id);
	}
}
