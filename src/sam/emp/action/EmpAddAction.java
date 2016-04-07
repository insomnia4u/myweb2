package sam.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.command.CommandHandler;
import sam.emp.model.EmpDAO;
import sam.emp.model.EmpDTO;

public class EmpAddAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String dept=req.getParameter("dept");
		
		EmpDTO dto=new EmpDTO(0, name, email, dept);
		EmpDAO dao=new EmpDAO();
		int result=dao.empAdd(dto);
		
		String msg=result>0?"성공!(삼)":"실패!";
		req.setAttribute("msg", msg);
		try {
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("쓰레드 돔!");
		
		dao.empDel(name);
			
		return "/emp/empMsg.jsp";
	}

}
