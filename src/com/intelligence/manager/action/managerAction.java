package com.intelligence.manager.action;




import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.intelligence.manager.service.*;
import com.intelligence.manager.vo.ItTitle;
import com.intelligence.common.Pagination;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class managerAction extends ActionSupport implements ServletRequestAware {

	private static Log logger = LogFactory.getLog(managerAction.class);
	private ItTitle itinfo;
	private HttpServletRequest request = null;
	private managerService managerService = null;
	Pagination itlist;
	
	public managerAction(){
		if (itlist ==null )
				itlist = new Pagination();
	}

	public managerService getManagerService() {
		return managerService;
	}

	public void setManagerService(managerService managerService) {
		this.managerService = managerService;
	}



	
public String listAll() throws Exception{
		
		String videoId = request.getParameter("videoId");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String plateType = request.getParameter("plateType");
		String plateNo = request.getParameter("plateNo");
		String sPage;
		
		int currentPage = Integer.parseInt((request.getParameter("startIndex")==null?"0":request.getParameter("startIndex")));
		if(currentPage<10){
			currentPage=1;
		}else{
			sPage =  String.valueOf(currentPage);
			currentPage =Integer.parseInt(sPage.substring(0,sPage.length()-1))+1;
		}
		
		itlist = managerService.tradAllList(videoId,startTime,endTime,plateType,plateNo,currentPage);
		
		request.getSession().removeAttribute("itlist");
		request.getSession().setAttribute("totalRows",itlist.getTotalRows());
		request.getSession().setAttribute("totalPages",itlist.getTotalPages());
		request.getSession().setAttribute("currentPage",itlist.getCurrentPage());
		request.getSession().setAttribute("startIndex",itlist.getStartIndex());
		request.getSession().setAttribute("lastIndex",itlist.getLastIndex());
		request.getSession().setAttribute("itlist", itlist);

		return SUCCESS;
	}



	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}

	public Pagination getItlist() {
		return itlist;
	}

	public void setItlist(Pagination itlist) {
		this.itlist = itlist;
	}

	
	
}
