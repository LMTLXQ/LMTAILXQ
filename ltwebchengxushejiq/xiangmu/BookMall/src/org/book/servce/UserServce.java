package org.book.servce;

import java.sql.ResultSet;
import java.util.List;

import org.book.dao.UserDao;
import org.book.entity.Page;
import org.book.entity.User;

public class UserServce {
	static ResultSet rs = null;
	//查询用户
	public boolean queryUser(User user) {
		return UserDao.queryUser(user);
	}
	
	//根据id查询用户
	public User queryUserById(int id) {
		return UserDao.QueryUserById(id);
	}
	//用户注冊
	public boolean addUser(User user){
		if(!UserDao.isExist(user.getUname())){
			return UserDao.addUser(user);
		}else{
			return false;
		}
	}
	
	//管理员查询所有用户
	public List<User> queryAllUser(int currentPage, int pageSize){
		return UserDao.queryAllUser(currentPage,pageSize);
	}
	
	//管理员删除用户
	public boolean deleteUser(int id){
		return UserDao.deleteUser(id);
	}
	
	//管理员修改用户
	public boolean updateUser(User user){
		return UserDao.updateUser(user);
	}
	
	//管理员模糊查询
	public List<User> fuzzyQueryUser(String name){
		return UserDao.fuzzyQueryUser(name);
	}
	
	//查询用户总数
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
