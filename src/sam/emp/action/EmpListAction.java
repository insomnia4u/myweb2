package sam.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xalan.internal.xslt.Process;

import sam.command.CommandHandler;
import java.util.*;
import sam.emp.model.*;

public class EmpListAction implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<EmpDTO> arr=new ArrayList<>();
		
		EmpDAO dao=new EmpDAO();
		
		arr=dao.empList();
		
		req.setAttribute("arr", arr);
		
		return "/emp/empList.jsp";
	}
}
