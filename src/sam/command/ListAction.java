package sam.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result="커맨드 패턴을 적용한 목록 보기";
		
		req.setAttribute("result", result);
		
		return "/list.jsp";
	}

}
