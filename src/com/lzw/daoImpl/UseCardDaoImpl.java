package com.lzw.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzw.dao.UseCardDao;
import com.lzw.db.DBUtil;
import com.lzw.entity.Department;
import com.lzw.entity.UseCard;

public class UseCardDaoImpl implements UseCardDao{

	@Override
	public int add(UseCard uc) {
		String sql = "insert into tb_usecard(id,departmentId,carId,startTime,endTime,head,driverName,notes)"
				+ "values(?,?,?,?,?,?,?,?)";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uc.getId());
			pstmt.setInt(2, uc.getDepartmentId());
			pstmt.setString(3, uc.getCarId());
			pstmt.setDate(4, uc.getStartTime());
			pstmt.setDate(5, uc.getEndTime());
			pstmt.setString(6, uc.getHead());
			pstmt.setString(7, uc.getDriverName());
			pstmt.setString(8, uc.getNotes());
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
	public int update(UseCard uc) {
		String sql = "update tb_usecard set departmentId=?,carId=?,startTime=?,endTime=?,head=?,driverName=?,notes=? where id='"+uc.getId()+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uc.getDepartmentId());
			pstmt.setString(2, uc.getCarId());
			pstmt.setDate(3, uc.getStartTime());
			pstmt.setDate(4, uc.getEndTime());
			pstmt.setString(5, uc.getHead());
			pstmt.setString(6, uc.getDriverName());
			pstmt.setString(7, uc.getNotes());
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
		String sql = "delete from tb_usecard where id='"+id+"'";
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
	public List<UseCard> findAll() {
		String sql = "select * from tb_usecard";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<UseCard> list = new ArrayList<UseCard>();
			while(re.next()){
				UseCard uc=null;
				uc = new UseCard(re.getInt("id"),re.getInt("departmentId"),re.getString("carId"),re.getDate("startTime"),
						re.getDate("endTime"),re.getString("head"),re.getString("driverName"),re.getString("notes"));
				list.add(uc);
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
	public List<UseCard> findByDe(String de) {
		String sql = "select * from tb_usecard where department='"+de+"'";
		System.out.println(sql);
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<UseCard> list = new ArrayList<UseCard>();
			while(re.next()){
				UseCard uc=null;
				uc = new UseCard(re.getInt("id"),re.getInt("departmentId"),re.getString("carId"),re.getDate("startTime"),
						re.getDate("endTime"),re.getString("head"),re.getString("driverName"),re.getString("notes"));
				list.add(uc);
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
	public List<UseCard> findByCar(String carId) {
		String sql = "select * from tb_usecard where carId='"+carId+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<UseCard> list = new ArrayList<UseCard>();
			while(re.next()){
				UseCard uc=null;
				uc = new UseCard(re.getInt("id"),re.getInt("departmentId"),re.getString("carId"),re.getDate("startTime"),
						re.getDate("endTime"),re.getString("head"),re.getString("driverName"),re.getString("notes"));
				list.add(uc);
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
	public List<UseCard> findByTime(Date be, Date to) {
		// TODO 自动生成的方法存根
		return null;
	}
	
	public UseCard findById(int id){
		String sql = "select * from tb_usecard where id='"+id+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			UseCard uc=null;
			if(re.next()){
				uc = new UseCard(re.getInt("id"),re.getInt("departmentId"),re.getString("carId"),re.getDate("startTime"),
						re.getDate("endTime"),re.getString("head"),re.getString("driverName"),re.getString("notes"));
			}
			return uc;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		return null;
	}

}
