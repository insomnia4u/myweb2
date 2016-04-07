package sam.page;

public class SamPage 
{
	public static String makePage(String pagename, int totalCnt, int listSize, int pageSize, int cp)
	{
		StringBuffer sb=new StringBuffer();
		
		int pageCnt=(totalCnt/listSize)+1;
		if(totalCnt%listSize==0)pageCnt--;
		   
		int userGroup=cp/pageSize;
		if(cp%pageSize==0)userGroup--;
		   
		
		if(userGroup!=0)
		{
		   sb.append("<a href='");
		   sb.append(pagename);
		   sb.append("?cp=");
		   
		   int tmp=(userGroup-1)*pageSize+pageSize;
		   
		   sb.append(tmp);
		   sb.append("'>&lt;&lt;</a>");
		}
		
		
		
		for(int i=(userGroup*pageSize)+1;i<=(userGroup*pageSize)+pageSize;i++)
		{
			sb.append("&nbsp;&nbsp;");
			sb.append("<a href='");
			sb.append(pagename);
			sb.append("?cp=");
			sb.append(i);
			sb.append("'>");
			sb.append(i);
			sb.append("</a>");
			sb.append("&nbsp;&nbsp;");
		
			if(i==pageCnt)
			{
		      break;
			}
		}
		
		if(userGroup!=(pageCnt/pageSize)-(pageCnt%pageSize==0?1:0))
		{
		   	sb.append("<a href='");
			sb.append(pagename);
			sb.append("?cp=");
			   
			int tmp=(userGroup+1)*pageSize+1;
			   
			   sb.append(tmp);
			   sb.append("'>&gt;&gt;</a>");
		}

		return sb.toString();
	} 
}
