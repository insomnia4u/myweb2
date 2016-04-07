package sam.bbs.model;

import java.sql.*;
import java.util.*;

import sam.db.*;
import sam.bbs.model.BbsDTO;

public class BbsDAO 
{
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
	
	public int BbsWrite(BbsDTO dto)
	{
		try
		{
			conn=SamDB.getConn();
			int ref=getMaxRef();
			String sql="insert into bbs values(bbs_idx.nextval, ?,?,?,?,sysdate,0,?,0,0)";
			
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getContent());
			ps.setInt(5, ref+1);
			
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
	
	//총 게시물 수  구하기
	public int getTotalCnt2()
	{
		try
		{
			conn=sam.db.SamDB.getConn();
			String sql="select count(*) from bbs";
			
			ps=conn.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			rs.next();
			
			return rs.getInt(1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
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
	
	
	
	public int getTotalCnt(){
		try{
			conn=SamDB.getConn();
			String sql="select count(*) as total from bbs";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			System.out.println("총 게시물 "+rs.getInt("total"));
			return rs.getInt("total");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			}catch(Exception e2){
				
			}
		}
	}
	
	public ArrayList<BbsDTO> BbsList(int cp, int ls){
		try{
			conn=SamDB.getConn();
//			String sql="select * from bbs order by idx desc";
			String sql="select * from "+
						"(select rownum as rnum,a.* from "+
						"(select * from bbs order by ref desc,sunbun asc)a)b "+
						"where rnum>=("+cp+"-1)*"+ls+"+1 and rnum<="+cp+"*"+ls;
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
				
			ArrayList<BbsDTO> arr=new ArrayList<BbsDTO>();
			while(rs.next()){
				int idx=rs.getInt("idx");
				String writer=rs.getString("writer");
				String pwd=rs.getString("pwd");
				String subject=rs.getString("subject");
				String content=rs.getString("content");
				java.util.Date writedate=rs.getDate("writedate");
				int readnum=rs.getInt("readnum");
				int ref=rs.getInt("ref");
				int lev=rs.getInt("lev");
				int sunbun=rs.getInt("sunbun");
				
				BbsDTO dto=new BbsDTO(idx, writer, pwd, subject, content, writedate, readnum, ref, lev, sunbun);
				arr.add(dto);
			}
			return arr;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			try{
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			}catch(Exception e2){
				
			}
		}
	}
	
	public BbsDTO BbsContent(int useridx)
	{
		try
		{
			conn=SamDB.getConn();
			
			String sql="select * from bbs where idx=?";
			
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1, useridx);
			
			rs=ps.executeQuery();
			
			rs.next();
			
			int idx=rs.getInt(1);
			String writer=rs.getString(2);
			String pwd=rs.getString(3);
			String subject=rs.getString(4);
			String content=rs.getString(5);
			java.util.Date writedate=rs.getDate(6);
			int readnum=rs.getInt(7);
			int ref=rs.getInt(8);
			int lev=rs.getInt(9);
			int sunbun=rs.getInt(10);
			
			BbsDTO dto=new BbsDTO(idx, writer, pwd, subject, content, writedate, readnum, ref, lev, sunbun);
			
			return dto;
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
	
	public HashMap<String, Integer> paging(int cp, int listSize)
	{
		int totalCnt=getTotalCnt();
		
		int pageSize=3;
		
		int pageCnt=(totalCnt/listSize)+1;
		int prevPageCnt=0;
		int nextPageCnt=0;

		
		System.out.println("현재페이지 : "+cp);
		System.out.println("리스트사이즈 : "+listSize);
		
		if(totalCnt%listSize==0)pageCnt--;
		
		int userGroup=cp/pageSize;
		if(cp%pageSize==0)userGroup--;
		
		System.out.println("usergroup : "+userGroup);
		
		if(userGroup==0)
		{
			
			prevPageCnt=1;
			nextPageCnt=pageSize;
			if(nextPageCnt>=pageCnt)
			{
				nextPageCnt=pageCnt;
			}
			
		}
		else if(userGroup!=0)
		{
			prevPageCnt=(userGroup-1)*pageSize+pageSize+1;
			nextPageCnt=(userGroup)*pageSize+pageSize;
			
			System.out.println("pageCnt : "+pageCnt);
			
			if(nextPageCnt>=pageCnt)
			{
				nextPageCnt=pageCnt;
			}
			
		}
	
		nextPageCnt++;
		prevPageCnt--;
		
		HashMap<String, Integer> pageMap=new HashMap<>();
		pageMap.put("prevPageCnt", prevPageCnt);
		pageMap.put("nextPageCnt", nextPageCnt);
		pageMap.put("pageCnt", pageCnt);
		
		System.out.println("이전페이지 : "+prevPageCnt);
		System.out.println("다음페이지 : "+nextPageCnt);
		
		return pageMap;
	}
	
    /**순번 수정 관련메서드*/
    public void sunUpdate(int ref, int sunbun){
       try{
          String sql="update bbs set sunbun=sunbun+1 where ref=? and sunbun>=?";
          ps=conn.prepareStatement(sql);
          ps.setInt(1, ref);
          ps.setInt(2, sunbun);
          ps.executeUpdate();
       }catch(Exception e){
          e.printStackTrace();
       }finally{
          try{
             if(ps!=null)ps.close();
          }catch(Exception e2){}
       }
    }
	
	   /**답변 글쓰기 관련메서드*/
    public int bbsReWrite(BbsDTO dto){
       try{
          conn=yong.db.yongDB.getConn();
          sunUpdate(dto.getRef(),dto.getSunbun()+1);
          String sql="insert into bbs values(bbs_idx.nextval,?,?,?,?,sysdate,0,?,?,?)";
          ps=conn.prepareStatement(sql);
          ps.setString(1, dto.getWriter());
          ps.setString(2, dto.getPwd());
          ps.setString(3, dto.getSubject());
          ps.setString(4, dto.getContent());
          ps.setInt(5, dto.getRef());
          ps.setInt(6, dto.getLev()+1);
          ps.setInt(7, dto.getSunbun()+1);
          int count=ps.executeUpdate();
          return count;
       }catch(Exception e){
          e.printStackTrace();
          return -1;
       }finally{
          try{
             if(ps!=null)ps.close();
             if(conn!=null)conn.close();
          }catch(Exception e2){}
       }
    }
}
