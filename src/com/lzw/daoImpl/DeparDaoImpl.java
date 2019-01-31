package com.lzw.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzw.dao.DepartmentDao;
import com.lzw.db.DBUtil;
import com.lzw.entity.Department;

public class DeparDaoImpl implements DepartmentDao{

	@Override
	public int add(Department de) {
		String sql = "insert into tb_department(id,password,department,head,phone)"
				+ "values(?,?,?,?,?)";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, de.getId());
			pstmt.setString(2, de.getPassword());
			pstmt.setString(3, de.getDepartment());
			pstmt.setString(4, de.getHead());
			pstmt.setString(5, de.getPhone());
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
	public int update(Department de) {
		int id = de.getId();
		String sql = "update tb_department set password=?,department=?,head=?,phone=? where id='"+id+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, de.getPassword());
			pstmt.setString(2, de.getDepartment());
			pstmt.setString(3, de.getHead());
			pstmt.setString(4, de.getPhone());
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
		String sql = "delete from tb_department where id='"+id+"'";
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
	public List<Department> findAll() {
		String sql = "select * from tb_department";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;	
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<Department> list = new ArrayList<Department>();
			while(re.next()){
				Department d=null;
				d = new Department(re.getInt("id"),re.getString("password"),re.getString("department"),
						re.getString("head"),re.getString("phone"));
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
	public Department findById(int id) {
		String sql = "select * from tb_department where id='"+id+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			Department d=null;
			if(re.next()){
				d = new Department(re.getInt("id"),re.getString("password"),re.getString("department"),
						re.getString("head"),re.getString("phone"));
			}
			return d;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public Department findByDe(String department) {
		String sql = "select * from tb_department where department='"+department+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			Department d=null;
			if(re.next()){
				d = new Department(re.getInt("id"),re.getString("password"),re.getString("department"),
						re.getString("head"),re.getString("phone"));
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

}
