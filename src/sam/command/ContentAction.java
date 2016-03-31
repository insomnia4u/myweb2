package sam.command;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result="본문 보기 기능 커맨트 re패턴 수행됨";
				
		req.setAttribute("result", result);
		
		return "/content.jsp";
	}

}
