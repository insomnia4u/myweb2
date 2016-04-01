package sam.emp.model;

import java.util.*;
import java.sql.*;

public class EmpDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public int empAdd(EmpDTO dto)
	{
		try
		{
			conn=sam.db.SamDB.getConn();
			String sql="insert into employee values(employee_idx.nextval,?,?,?)";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getDept());
			int count=ps.executeUpdate();
			
			return count;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		finally
		{
			try
			{
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}
			catch(Exception e2)
			{
				
			}
		}
	}
	
	public int empDel(String eName)
	{
		try
		{
			conn=sam.db.SamDB.getConn();
			String sql="delete from employee where name=?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, eName);
			int count=ps.executeUpdate();
			
			return count;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
		finally
		{
			try
			{
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}
			catch(Exception e2)
			{
				
			}
		}
	}
}
