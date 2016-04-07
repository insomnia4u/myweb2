package sam.bbs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.bbs.model.BbsDAO;
import sam.bbs.model.BbsDTO;
import sam.command.CommandHandler;

public class BbsReWriteAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String writer=req.getParameter("writer");
		String pwd=req.getParameter("pwd");
		String subject=req.getParameter("subject");
		String content=req.getParameter("content");
		
		int ref=Integer.parseInt(req.getParameter("ref"));
		int lev=Integer.parseInt(req.getParameter("lev"));
		int sunbun=Integer.parseInt(req.getParameter("sunbun"));
		
		BbsDTO dto=new BbsDTO();
		dto.setWriter(writer);
		dto.setPwd(pwd);
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setRef(ref);
		dto.setLev(lev);
		dto.setSunbun(sunbun);
		
		BbsDAO dao=new BbsDAO();
		
		String msg=dao.bbsReWrite(dto)>0?"성공":"실패";
		
		req.setAttribute("msg", msg);
		
		return "/bbs/bbsMsg.jsp";

	}

}
