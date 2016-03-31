package sam.controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.command.CommandHandler;
import sam.command.*;

import java.util.*;

public class SamController extends HttpServlet
{
	private Map commandMap;
	
	public SamController() {
		commandMap=new HashMap<String, Object>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String path=config.getServletContext().getRealPath("/WEB-INF/samCommand.properties");
		
		//System.out.println("path="+path);
		
		java.util.Properties prop=null;
		
		try {
			FileInputStream fis=new FileInputStream(path);
			prop= new java.util.Properties();
			prop.load(fis);
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		Iterator keys=prop.keySet().iterator();
		while(keys.hasNext())
		{
			String key=(String)keys.next();
			String classpath=prop.getProperty(key);
			
			try {
				Class obj_class=Class.forName(classpath);
				try {
					Object obj=obj_class.getClass().newInstance();
					commandMap.put(key, obj);
					
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userProcess(req, resp);
	}
	
	
	protected void userProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. HTTP 요청 받음(awt obj반환 받음)
		String type=req.getParameter("type");
		
		//2. 요구 기능 분석
		//String result=null;
		CommandHandler command=(CommandHandler)commandMap.get(type);
		
		
		String goPage=null;
		
//		if(type.equals("list"))
//		{
//			//3. 기능 처리
//			command=new ListAction();
//				
//		}
//		else if(type.equals("write"))
//		{
//			command=new WriteAction();
//
//		}
//		else if(type.equals("content"))
//		{
//			
//			command=new ContentAction();
//		}
//		
		//4. 결과 저장
		//req.setAttribute("result", result);
		
		goPage=command.process(req, resp);
		
		//5. 이동
		RequestDispatcher dis=req.getRequestDispatcher(goPage);
		
		dis.forward(req, resp);
	}
}
