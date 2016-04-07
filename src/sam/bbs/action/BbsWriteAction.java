package sam.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.command.CommandHandler;
import java.util.*;
import sam.bbs.model.*;

public class BbsWriteAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String writer=req.getParameter("writer");
		String pwd=req.getParameter("pwd");
		String subject=req.getParameter("subject");
		String content=req.getParameter("content");
		
		BbsDTO dto=new BbsDTO();
		dto.setWriter(writer);
		dto.setPwd(pwd);
		dto.setSubject(subject);
		dto.setContent(content);
		
		BbsDAO dao=new BbsDAO();
		
		String msg=dao.BbsWrite(dto)>0?"성공":"실패";
		
		req.setAttribute("msg", msg);
		
		return "/bbs/bbsMsg.jsp";
	}

}
