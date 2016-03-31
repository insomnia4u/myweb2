package yong.emp.model;

import java.sql.*;
import java.util.*;

public class EmpDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public EmpDAO() {
		
	}
	//사원등록
	public int empAdd(EmpDTO dto){
		
		try {
			conn=yong.db.yongDB.getConn();
			String sql="insert into employee values(employee_idx.nextval,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getDept());
			int count=ps.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
	//사원삭제
	public int empDel(EmpDTO dto){
		
		try {
			conn=yong.db.yongDB.getConn();
			String sql="delete from employee where name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			int count=ps.executeUpdate();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
}
