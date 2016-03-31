package sam.emp.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.command.CommandHandler;

public class EmpAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		return "/emp/emp.jsp";
	}

}
