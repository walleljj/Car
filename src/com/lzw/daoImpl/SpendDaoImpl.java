package com.lzw.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzw.dao.SpendDao;
import com.lzw.db.DBUtil;
import com.lzw.entity.Drivers;
import com.lzw.entity.SpendCard;

public class SpendDaoImpl implements SpendDao{

	@Override
	public int add(SpendCard sc) {
		String sql = "insert into tb_spendcard(id,carId,spendMoney,reason,time,notes)"
				+ "values(?,?,?,?,?,?)";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sc.getId());
			pstmt.setString(2, sc.getCarId());
			pstmt.setInt(3, sc.getSpendMoney());
			pstmt.setString(4, sc.getReason());
			pstmt.setDate(5, sc.getTime());
			pstmt.setString(6, sc.getNotes());
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
	public int update(SpendCard sc) {
		String sql = "update tb_spendcard set carId=?,spendMoney=?,reason=?,time=?,notes=? where id='"+sc.getId()+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sc.getCarId());
			pstmt.setInt(2, sc.getSpendMoney());
			pstmt.setString(3, sc.getReason());
			pstmt.setDate(4, sc.getTime());
			pstmt.setString(5, sc.getNotes());
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
		String sql = "delete from tb_spendcard where id='"+id+"'";
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
	public List<SpendCard> findAll() {
		String sql = "select * from tb_spendcard";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<SpendCard> list = new ArrayList<SpendCard>();
			while(re.next()){
				SpendCard sc=null;
				sc = new SpendCard(re.getInt("id"),re.getString("carId"),re.getInt("spendMoney"),
						re.getString("reason"),re.getDate("time"),re.getString("notes"));
				list.add(sc);
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
	public List<SpendCard> findByCar(String carId) {
		String sql = "select * from tb_spendcard where carId='"+carId+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<SpendCard> list = new ArrayList<SpendCard>();
			while(re.next()){
				SpendCard sc=null;
				sc = new SpendCard(re.getInt("id"),re.getString("carId"),re.getInt("spendMoney"),
						re.getString("reason"),re.getDate("time"),re.getString("notes"));
				list.add(sc);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
        public SpendCard findById(int id){
            String sql = "select * from tb_spendcard where id='"+id+"'";
            Connection conn =  DBUtil.open();
    		PreparedStatement pstmt;	
    		try {
    			pstmt = conn.prepareStatement(sql);
    			ResultSet re = pstmt.executeQuery();
    			SpendCard sc=null;
    			if(re.next()){				
    				sc = new SpendCard(re.getInt("id"),re.getString("carId"),re.getInt("spendMoney"),
    						re.getString("reason"),re.getDate("time"),re.getString("notes"));
    			}
    			return sc;
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}finally{
    			DBUtil.close(conn);
    		}
            return null;
        }
        public List<SpendCard> findByReason(String carId) {
		String sql = "select * from tb_spendcard where reason='"+carId+"'";
		Connection conn =  DBUtil.open();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet re = pstmt.executeQuery();
			List<SpendCard> list = new ArrayList<SpendCard>();
			while(re.next()){
				SpendCard sc=null;
				sc = new SpendCard(re.getInt("id"),re.getString("carId"),re.getInt("spendMoney"),
						re.getString("reason"),re.getDate("time"),re.getString("notes"));
				list.add(sc);
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
