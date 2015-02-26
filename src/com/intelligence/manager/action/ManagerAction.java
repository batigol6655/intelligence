package com.intelligence.manager.action;




import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.intelligence.manager.service.*;
import com.intelligence.manager.vo.ItTitle;
import com.intelligence.view.service.ShowService;
import com.intelligence.common.Pagination;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ManagerAction extends ActionSupport implements ServletRequestAware {

	private static Log logger = LogFactory.getLog(ManagerAction.class);
	private ItTitle itinfo;
	private HttpServletRequest request;
	private ManagerService managerService;
	private ShowService showService;
	private ArrayList<ItTitle> allLists;
	Pagination itlist;
	
	public ManagerAction(){
		if (itlist ==null )
				itlist = new Pagination();
	}

	public String list() throws Exception{
		allLists =  (ArrayList<ItTitle>)showService.list();
		request.getSession().setAttribute("allLists",allLists);
		return SUCCESS;
	}
	
	
	
	public ShowService getShowService() {
		return showService;
	}

	public void setShowService(ShowService showService) {
		this.showService = showService;
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
