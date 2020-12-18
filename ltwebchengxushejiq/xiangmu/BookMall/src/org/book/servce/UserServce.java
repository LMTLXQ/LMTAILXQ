package org.book.servce;

import java.sql.ResultSet;
import java.util.List;

import org.book.dao.UserDao;
import org.book.entity.Page;
import org.book.entity.User;

public class UserServce {
	static ResultSet rs = null;
	//��ѯ�û�
	public boolean queryUser(User user) {
		return UserDao.queryUser(user);
	}
	
	//����id��ѯ�û�
	public User queryUserById(int id) {
		return UserDao.QueryUserById(id);
	}
	//�û�ע��
	public boolean addUser(User user){
		if(!UserDao.isExist(user.getUname())){
			return UserDao.addUser(user);
		}else{
			return false;
		}
	}
	
	//����Ա��ѯ�����û�
	public List<User> queryAllUser(int currentPage, int pageSize){
		return UserDao.queryAllUser(currentPage,pageSize);
	}
	
	//����Աɾ���û�
	public boolean deleteUser(int id){
		return UserDao.deleteUser(id);
	}
	
	//����Ա�޸��û�
	public boolean updateUser(User user){
		return UserDao.updateUser(user);
	}
	
	//����Աģ����ѯ
	public List<User> fuzzyQueryUser(String name){
		return UserDao.fuzzyQueryUser(name);
	}
	
	//��ѯ�û�����
	public int querySun(){
		return UserDao.querySum();
	}
//	public static void main(String[] args) {
//		User user = new User();
//		user.setUname("chc");
//		queryUser(user);
//		
//	}
}
