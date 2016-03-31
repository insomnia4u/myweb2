package yong.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yong.command.CommandHandler;
import yong.emp.model.EmpDAO;
import yong.emp.model.EmpDTO;

public class EmpDelAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
	
		
		EmpDTO dto=new EmpDTO(0, name);
		EmpDAO dao=new EmpDAO();
		int result=dao.empDel(dto);
		
		
		String msg=result>0?"사원삭제 성공!":"사원삭제 실패!";
		req.setAttribute("msg", msg);
		
			
		return "/emp/empMsg.jsp";
		
	}

}
