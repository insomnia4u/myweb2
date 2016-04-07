package sam.emp.model;

import java.util.*;
import java.sql.*;

public class EmpDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public int getMaxRef(){
		try{
			String sql="select max(ref) from bbs";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			int max=0;
			if(rs.next()){
				max=rs.getInt(1);
			}
			return max;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			try{
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
			}catch(Exception e2){
				
			}
		}
	}
	
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
	
	public ArrayList<EmpDTO> empList()
	{
		try
		{
			conn=sam.db.SamDB.getConn();
			String sql="select * from employee order by idx asc";
			
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			ArrayList<EmpDTO> dtos=new ArrayList<>();
			
			while(rs.next())
			{
				int idx=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String dept=rs.getString(4);
				
				EmpDTO dto=new EmpDTO(idx, name, email, dept);
				
				dtos.add(dto);
								
			}
			
			return dtos;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
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
	
	public ArrayList<EmpDTO> empFind(String eName)
	{
		try
		{
			conn=sam.db.SamDB.getConn();
			
			String sql="select * from employee where name=?";
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, eName);
			rs=ps.executeQuery();
			
			ArrayList<EmpDTO> arr=new ArrayList<>();
			
			while(rs.next())
			{
				int idx=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String dept=rs.getString(4);
				
				EmpDTO dto=new EmpDTO(idx, name, email, dept);
				
				arr.add(dto);
				
				
			}
			return arr;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try
			{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}
			catch(Exception e2)
			{
				
			}
		}
	}
	
	public ArrayList<EmpDTO> empFind(int eIdx)
	{
		try
		{
			conn=sam.db.SamDB.getConn();
			
			String sql="select * from employee where idx=?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, eIdx);
			
			rs=ps.executeQuery();
			
			ArrayList<EmpDTO> arr=new ArrayList<>();
			
			while(rs.next())
			{
				int idx=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String dept=rs.getString(4);
				
				EmpDTO dto=new EmpDTO(idx, name, email, dept);
				
				arr.add(dto);
				
				
			}
			return arr;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try
			{
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			}
			catch(Exception e2)
			{
				
			}
		}
	}
	
	public int empEdit(int idx, EmpDTO indto)
	{
		try
		{
			conn=sam.db.SamDB.getConn();
			
			String sql="update employee set idx=?, name=?, email=?, dept=? where idx="+idx;
			
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1,indto.getIdx() );
			ps.setString(2, indto.getName());
			ps.setString(3, indto.getEmail());
			ps.setString(4, indto.getDept());
			
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
