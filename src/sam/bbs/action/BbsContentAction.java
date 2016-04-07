package sam.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.command.CommandHandler;
import java.util.*;
import sam.bbs.model.*;

public class BbsContentAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int useridx=Integer.parseInt(req.getParameter("idx"));
		
		
		
		BbsDAO dao=new BbsDAO();
		
		BbsDTO dto=new BbsDTO();
		dto=dao.BbsContent(useridx);
		String con=dto.getContent().replaceAll("\r\n", "<br>");
		
		dto.setContent(con);
		
		req.setAttribute("dto", dto);
		
		return "/bbs/bbsContent.jsp";
	}

}
