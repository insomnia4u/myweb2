package yong.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result="커맨드에서 수행된 업데이트~!";
		req.setAttribute("result", result);
		return "/update.jsp";
	}

}
