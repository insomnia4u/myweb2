package sam.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.command.CommandHandler;
import java.util.*;
import sam.emp.model.*;

public class EmpEditAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sIdx=req.getParameter("idx");
		
		int idx=Integer.parseInt(sIdx);
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String dept=req.getParameter("dept");
		
		System.out.println("edit process 수행됨");
		EmpDAO dao=new EmpDAO();
		
		EmpDTO dto=new EmpDTO(idx, name, email, dept);
				
		int res=dao.empEdit(idx, dto);
		System.out.println("empEdit 수행됨");
		ArrayList<EmpDTO> arr=dao.empList();
		System.out.println("empList 수행됨");
		req.setAttribute("arr", arr);
		
		return "emp/empList.jsp";
	}

}
