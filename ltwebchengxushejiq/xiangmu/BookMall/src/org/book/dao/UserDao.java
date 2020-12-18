package org.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.book.entity.User;
import org.book.util.DBUtil;

public class UserDao {
	//查询用户		登录
	public static boolean queryUser(User user) {

		ResultSet rs = null;
		String sql = "select pwd from user where name= ?";
		Object[] params = {user.getUname()};
		System.out.println("userName:"+user.getUname());
		rs = DBUtil.executeQuery(sql, params);
		try {
			if(rs.next()) {
				String pwd = rs.getString(1);
				System.out.println("daoPwd:"+pwd);
				if(pwd.equals(user.getUpwd())) {
					return true;
				}else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(DBUtil.co, DBUtil.ps, rs);
		}
		return false;
	}
	
	//查询所有用户
	public static List<User> queryAllUser(int currentPage, int pageSize){
		ResultSet rs = null;
		String sql = "select * from user limit ?,?";
		Object[] params = {(currentPage-1)*pageSize,currentPage*pageSize};
		List<User> list = new ArrayList<>();
		rs=DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()){
				User user = new User();//user对象要写到while循环内，不然user内的数据会被最后一个数据替换
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("name"));
				user.setUpwd(rs.getString("pwd"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(DBUtil.co, DBUtil.ps, rs);
		}
		return list;
	}
	
	//模糊查询用户
	public static List<User> fuzzyQueryUser(String name){
		ResultSet rs = null;
		String sql = "select * from user where name like ?";
		String name1 = "%"+name+"%";
		Object[] params ={name1};
		List<User> list = new ArrayList<>();
		rs=DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()){
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("name"));
				user.setUpwd(rs.getString("pwd"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(DBUtil.co, DBUtil.ps, rs);
		}
		return list;
	}
	
	//查询用户
	public static User QueryUserById(int id){
		ResultSet rs = null;
		String sql = "select * from user where id=?";
		Object[] params ={id};
		rs=DBUtil.executeQuery(sql, params);
		User user = new User();
		try {
			if(rs.next()){
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("name"));
				user.setUpwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(DBUtil.co, DBUtil.ps, rs);
		}
		return user;
	}
	
	//添加用户
	public static boolean addUser(User user){
		String sql = "insert into user (name,pwd) values(?,?)";
		Object[] params = {user.getUname(),user.getUpwd()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//修改用户
	public static boolean updateUser(User user){
		String sql = "update user set name = ?,pwd=? where uid =?";
		Object[] params = {user.getUname(),user.getUpwd(),user.getUid()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//删除用户
	public static boolean deleteUser(int id){
		String sql = "delete from user where uid = ?";
		Object[] params = {id};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//查询用户是否存在
	public static boolean isExist(String name){
		String sql = "select * from user where name = ?";
		Object[] params = {name};
		int count = DBUtil.totalNumber(sql, params);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	//查询用户总数
	public static int querySum(){
		ResultSet rs = null;
		String sql = "select count(1) from user";
		Object[] params = null;
		rs = DBUtil.executeQuery(sql, params);
		int sum = -1;
		try {
			if(rs.next()){
				sum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(DBUtil.co, DBUtil.ps, rs);
		}
		return sum;
	}
}
