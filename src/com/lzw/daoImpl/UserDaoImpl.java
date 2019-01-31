package com.lzw.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzw.dao.UserDao;
import com.lzw.db.DBUtil;
import com.lzw.entity.User;

public class UserDaoImpl implements UserDao{

	@Override
	public int add(User user) {
		String sql = "insert into tb_user(id,password,name,phoneNumber,sex,isOk)"
				+ "values(?,?,?,?,?,?)";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getPhoneNumber());
			pstmt.setString(5, user.getSex());
			pstmt.setInt(6, user.getIsOk());
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return 0;
	}
	//添加管理员
	@Override
	public int update(User user) {
		String sql = "update tb_user set password=?,name=?,phoneNumber=?,sex=?,isOk=? where id="+user.getId();
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPhoneNumber());
			pstmt.setString(4, user.getSex());
			pstmt.setInt(5, user.getIsOk());
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return 0;
	}
	//删除管理员
	@Override
	public int delet(int id) {
		String sql = "delete from tb_user where id="+id;
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return 0;
	}
	//查询所有管理员
	@Override
	public List<User> findAll() {
		String sql = "select * from tb_user";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;	
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<User> list = new ArrayList<User>();
			while(re.next()){
				User u=null;
				u = new User(re.getInt("id"),re.getString("password"),
						re.getString("name"),re.getString("phoneNumber"),re.getString("sex"),re.getInt("isOk"));
				list.add(u);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
	//通过id查找管理员
	@Override
	public User findById(int id) {
		String sql = "select * from tb_user where id="+id;
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;	
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			User u=null;
			if(re.next()){				
				u = new User(re.getInt("id"),re.getString("password"),
						re.getString("name"),re.getString("phoneNumber"),re.getString("sex"),re.getInt("isOk"));
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
	//查找
	@Override
	public List<User> findByIsOk(int isOk) {
		String sql = "select * from tb_user where isOk="+isOk;
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;	
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<User> list = new ArrayList<User>();
			while(re.next()){
				User u=null;
				u = new User(re.getInt("id"),re.getString("password"),
						re.getString("name"),re.getString("phoneNumber"),re.getString("sex"),re.getInt("isOk"));
				list.add(u);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

}
