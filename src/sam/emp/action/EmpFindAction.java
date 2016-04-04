package sam.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.command.CommandHandler;
import java.util.*;
import sam.emp.model.*;

public class EmpFindAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String param=req.getParameter("param");
		
		ArrayList<EmpDTO> arr=new ArrayList<>();
		
		try{
			int eIdx=Integer.parseInt(param);
			
			EmpDAO dao=new EmpDAO();
			
			arr=dao.empFind(eIdx);
		}
		catch(NumberFormatException e)
		{
			EmpDAO dao=new EmpDAO();
			
			arr=dao.empFind(param);
		}
		
		req.setAttribute("dtos", arr);
		
		
		return "/emp/empFind.jsp";
	}

}
