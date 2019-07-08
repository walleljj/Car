package com.lzw.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzw.dao.CarDao;
import com.lzw.db.DBUtil;
import com.lzw.entity.Car;

public class CarDaoImpl implements CarDao {
	//增加汽车信息
	public int add(Car car) {
		String sql = "insert into tb_car(id,type,volume,inTime,value,isOk,state,notes)"
				+ "values(?,?,?,?,?,?,?,?)";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getId());
			pstmt.setString(2, car.getType());
			pstmt.setInt(3, car.getVolume());
			pstmt.setDate(4, car.getInTime());
			pstmt.setInt(5, car.getValue());
			pstmt.setInt(6, car.getIsOk());
			pstmt.setString(7, car.getState());
			pstmt.setString(8, car.getNotes());
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return 0;
	}
	//修改汽车信息
	@Override
	public int update(Car car) {
		String id = car.getId();
		String sql = "update tb_car set type=?,volume=?,inTime=?,value=?,isOk=?,state=?,notes=? where id='"+id+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getType());
			pstmt.setInt(2, car.getVolume());
			pstmt.setDate(3, car.getInTime());
			pstmt.setInt(4, car.getValue());
			pstmt.setInt(5, car.getIsOk());
			pstmt.setString(6, car.getState());
			pstmt.setString(7, car.getNotes());
			pstmt.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return 0;
		
	}
	//删除汽车
	@Override
	public int delet(String id) {
		String sql = "delete from tb_car where id="+id;
		System.out.println(sql);
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
	//通过车牌查找
	@Override
	public Car findById(String id) {
		String sql = "select * from tb_car where id='"+id+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			Car c=null;
			if(re.next()){
				c = new Car(id,re.getString("type"),re.getInt("volume"),re.getDate("inTime"),
						re.getInt("value"),re.getInt("isOk"),re.getString("state"),re.getString("notes"));
			}
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public List<Car> findByVolume(int volume) {
		String sql = "select * from tb_car where volume='"+volume+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<Car> list = new ArrayList<Car>();
			while(re.next()){
				Car c=null;
				c = new Car(re.getString("id"),re.getString("type"),volume,re.getDate("inTime"),
						re.getInt("value"),re.getInt("isOk"),re.getString("state"),re.getString("notes"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
	//根据汽车的状态查询
	@Override
	public List<Car> findByState(String state) {
		String sql = "select * from tb_car where state='"+state+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<Car> list = new ArrayList<Car>();
			while(re.next()){
				Car c=null;
				c = new Car(re.getString("id"),re.getString("type"),re.getInt("volume"),re.getDate("inTime"),
						re.getInt("value"),re.getInt("isOk"),re.getString("state"),re.getString("notes"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
	//根据汽车是否可用查询
	@Override
	public List<Car> findByIsOk(int isok) {
		String sql = "select * from tb_car where isOk='"+isok+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<Car> list = new ArrayList<Car>();
			while(re.next()){
				Car c=null;
				c = new Car(re.getString("id"),re.getString("type"),re.getInt("volume"),re.getDate("inTime"),
						re.getInt("value"),re.getInt("isOk"),re.getString("state"),re.getString("notes"));
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
	//根据汽车的种类查询
	@Override
	public List<Car> findByType(String type) {
		String sql = "select * from tb_car where type='"+type+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<Car> list = new ArrayList<Car>();
			while(re.next()){
				Car c=null;
				c = new Car(re.getString("id"),re.getString("type"),re.getInt("volume"),re.getDate("inTime"),
						re.getInt("value"),re.getInt("isOk"),re.getString("state"),re.getString("notes"));
				list.add(c);
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
	public List<Car> findAll() {
		String sql = "select * from tb_car";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<Car> list = new ArrayList<Car>();
			while(re.next()){
				Car c=null;
				c = new Car(re.getString("id"),re.getString("type"),re.getInt("volume"),re.getDate("inTime"),
						re.getInt("value"),re.getInt("isOk"),re.getString("state"),re.getString("notes"));
				list.add(c);
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
