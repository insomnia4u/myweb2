package sam.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result="글쓰기 커맨드패턴 수행됨";
		
		req.setAttribute("result", result);
		
		return "/write.jsp";
	}

}
