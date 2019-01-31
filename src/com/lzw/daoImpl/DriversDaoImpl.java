package com.lzw.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzw.dao.DriversDao;
import com.lzw.db.DBUtil;
import com.lzw.entity.Drivers;

public class DriversDaoImpl implements DriversDao{

	@Override
	public int add(Drivers dri) {
		String sql = "insert into tb_drivers(id,name,type,phone,state,isOk)"
				+ "values(?,?,?,?,?,?)";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dri.getId());
			pstmt.setString(2, dri.getName());
			pstmt.setString(3, dri.getType());
			pstmt.setString(4, dri.getPhone());
			pstmt.setString(5, dri.getState());
			pstmt.setInt(6, dri.getIsOk());
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return 0;
	}

	@Override
	public int update(Drivers dri) {
		String sql = "update tb_drivers set name=?,type=?,phone=?,state=?,isOk=? where id='"+dri.getId()+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dri.getName());
			pstmt.setString(2, dri.getType());
			pstmt.setString(3, dri.getPhone());
			pstmt.setString(4, dri.getState());
			pstmt.setInt(5, dri.getIsOk());
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return 0;
	}

	@Override
	public int delet(int id) {
		String sql = "delete from tb_drivers where id="+id;
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

	@Override
	public List<Drivers> findAll() {
		String sql = "select * from tb_drivers";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;	
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<Drivers> list = new ArrayList<Drivers>();
			while(re.next()){
				Drivers d=null;
				d = new Drivers(re.getInt("id"),re.getString("type"),
						re.getString("name"),re.getString("phone"),re.getString("state"),re.getInt("isOk"));
				list.add(d);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public List<Drivers> findByIsOk(int isOk) {
		String sql = "select * from tb_drivers where isOk='"+isOk+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;	
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<Drivers> list = new ArrayList<Drivers>();
			while(re.next()){
				Drivers d=null;
				d = new Drivers(re.getInt("id"),re.getString("type"),
						re.getString("name"),re.getString("phone"),re.getString("state"),re.getInt("isOk"));
				list.add(d);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public List<Drivers> findByType(String t) {
		final String sql = "select * from tb_drivers where type='"+t+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;	
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<Drivers> list = new ArrayList<Drivers>();
			while(re.next()){
				Drivers d=null;
				d = new Drivers(re.getInt("id"),re.getString("type"),
						re.getString("name"),re.getString("phone"),re.getString("state"),re.getInt("isOk"));
				list.add(d);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public Drivers findById(int id) {
		String sql = "select * from tb_drivers where id='"+id+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;	
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			Drivers d=null;
			if(re.next()){				
				d = new Drivers(re.getInt("id"),re.getString("type"),
						re.getString("name"),re.getString("phone"),re.getString("state"),re.getInt("isOk"));
			}
			return d;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
        public boolean isNumber (String str){
            try{
                Integer.parseInt(str);
                return true;
            }catch(Exception e){
                return false;
            }
        }
        public List<Drivers> findByName(String name) {
		String sql = "select * from tb_drivers where name='"+name+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;	
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<Drivers> list = new ArrayList<Drivers>();
			while(re.next()){
				Drivers d=null;
				d = new Drivers(re.getInt("id"),re.getString("type"),
						re.getString("name"),re.getString("phone"),re.getString("state"),re.getInt("isOk"));
				list.add(d);
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
