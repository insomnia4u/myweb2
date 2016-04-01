package sam.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.command.CommandHandler;
import sam.emp.model.EmpDAO;
import sam.emp.model.EmpDTO;

public class EmpDelAction implements CommandHandler {

	
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
	
		EmpDAO dao=new EmpDAO();
		int result=dao.empDel(name);
		
		String msg=result>0?"성공!":"실패!";
		req.setAttribute("msg", msg);
		
			
		return "/emp/empMsg.jsp";
	}

}
