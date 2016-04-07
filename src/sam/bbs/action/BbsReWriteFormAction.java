package sam.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.command.CommandHandler;
import sam.bbs.model.*;

public class BbsReWriteFormAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String idx_s=req.getParameter("idx");
		
		int idx=Integer.parseInt(idx_s);
		
		BbsDAO dao=new BbsDAO();
		
		BbsDTO dto=dao.BbsContent(idx);
		
		req.setAttribute("dto", dto);
		
		return "bbs/bbsReWrite.jsp";
	}

}
