package sam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.binding.ContentBinding;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import sam.command.CommandHandler;
import sam.command.*;

public class SamController extends HttpServlet
{
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
		CommandHandler command=null;
		
		
		String goPage=null;
		
		if(type.equals("list"))
		{
			//3. 기능 처리
			command=new ListAction();
				
		}
		else if(type.equals("write"))
		{
			command=new WriteAction();

		}
		else if(type.equals("content"))
		{
			
			command=new ContentAction();
		}
		
		//4. 결과 저장
		//req.setAttribute("result", result);
		
		goPage=command.process(req, resp);
		
		//5. 이동
		RequestDispatcher dis=req.getRequestDispatcher(goPage);
		
		dis.forward(req, resp);
	}
}
