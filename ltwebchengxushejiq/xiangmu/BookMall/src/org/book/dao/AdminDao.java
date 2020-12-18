package org.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.book.entity.Admin;
import org.book.util.DBUtil;

public class AdminDao {
	// ��ѯ����Ա ��¼
	public static boolean queryAdmin(Admin admin) {

		ResultSet rs = null;
		String sql = "select pwd from admin where name=?";
		Object[] params = {admin.getAname()};
		rs = DBUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				String pwd = rs.getString(1);
				System.out.println(pwd);
				if (pwd.equals(admin.getApwd())) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(DBUtil.co, DBUtil.ps, rs);
		}
		return false;
	}
	
	//��ѯ���й���Ա
	public static List<Admin> queryAllAdmin(int currentPage, int pageSize) {

		ResultSet rs = null;
		String sql = "select * from admin limit ?,?";
		Object[] params = {(currentPage-1)*pageSize,currentPage*pageSize};
		List<Admin> list = new ArrayList<>();
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()){
				Admin admin = new Admin();//user����Ҫд��whileѭ���ڣ���Ȼuser�ڵ����ݻᱻ���һ�������滻
				admin.setAid(rs.getInt("aid"));
				admin.setAname(rs.getString("name"));
				admin.setApwd(rs.getString("pwd"));
				list.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(DBUtil.co, DBUtil.ps, rs);
		}
		return list;
	}

	//����Աע��
	public static boolean addAdmin(Admin admin){
		String sql = "insert into admin (name,pwd) values(?,?)";
		Object[] params = {admin.getAname(),admin.getApwd()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//�鿴����Ա�Ƿ����
	public static boolean isExist(String name){
		String sql = "select * from admin where name = ?";
		Object[] params = {name};
		int count = DBUtil.totalNumber(sql, params);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	//��ѯ����Ա����
	public static int querySum(){
		ResultSet rs = null;
		String sql = "select count(1) from admin";
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
	
	//�޸Ĺ���Ա
	public static boolean updateAdmin(Admin admin){
		String sql = "update admin set name = ?,pwd=? where aid =?";
		Object[] params = {admin.getAname(),admin.getApwd(),admin.getAid()};
		return DBUtil.executeUpdate(sql, params);
	}
		
	//ɾ������Ա
	public static boolean deleteAdmin(int id){
		String sql = "delete from admin where aid = ?";
		Object[] params = {id};
		return DBUtil.executeUpdate(sql, params);
	}
}
