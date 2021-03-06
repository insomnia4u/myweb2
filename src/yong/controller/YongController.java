package yong.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.command.CommandHandler;
import yong.command.ContentAction;
import yong.command.ListAction;
import yong.command.UpdateAction;
import yong.command.WriteAction;
import java.util.*;



public class YongController extends HttpServlet{
    
	private Map commandMap;
    
	public YongController() {
		commandMap=new HashMap<String,Object>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
	    String path=config.getServletContext().getRealPath("/WEB-INF/yongCommand.properties");
	   // System.out.println("path="+path);
	    Properties prop=null;
	    try {
			FileInputStream fis=
					new FileInputStream(path);
			prop=new Properties();
			prop.load(fis);
			fis.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	    
	    Iterator keys=prop.keySet().iterator();
	    while(keys.hasNext()){
	    	String key=(String)keys.next();
	    	String classPath=prop.getProperty(key);
	    	
	    	try {
				Class obj_class=Class.forName(classPath);
				Object obj=obj_class.newInstance();
				commandMap.put(key, obj);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
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
		//1.http 요청받음(awt의 obj반환받음)
		//String type=req.getParameter("type");
		
		String type=null;
		String userUrl=req.getRequestURI();
		if(userUrl.indexOf(req.getContextPath())==0){
			type=userUrl.substring(req.getContextPath().length());
		}
		
		//2.요구기능분석
		CommandHandler command=
				(CommandHandler)commandMap.get(type);
		String goPage=null;
		
		
		//4.결과저장
		goPage=command.process(req, resp);
		//5.이동
		RequestDispatcher dis=
				req.getRequestDispatcher(goPage);
		dis.forward(req, resp);
	}
	
}
