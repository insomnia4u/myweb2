package sam.bbs.action;

import java.io.IOException;
import java.util.*;

import sam.bbs.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sam.command.CommandHandler;


public class BbsListAction implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BbsDAO dao=new BbsDAO();
		
		String cp_s=req.getParameter("cp");
		
		if(cp_s==null||cp_s.equals(""))
		{
			cp_s="1";
		}
		
		int cp=Integer.parseInt(cp_s);
		
		int totalCnt=dao.getTotalCnt2();
		int listSize=2;
		int pageSize=5;
				
		ArrayList<BbsDTO> arr=dao.BbsList(cp, listSize);
		
		String pageStr=sam.page.SamPage.makePage("bbsList.sam", totalCnt, listSize, pageSize, cp);
		
		req.setAttribute("pageStr", pageStr);
		req.setAttribute("dto", arr);
		
//		HashMap<String, Integer> pages=dao.paging(cp, listSize);
//		

//		req.setAttribute("pages", pages);

		
		return "/bbs/bbsList.jsp";
	}

}
