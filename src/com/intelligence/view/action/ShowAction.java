package com.intelligence.view.action;



import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.intelligence.common.DisposalCode;
import com.intelligence.common.Pagination;
import com.intelligence.manager.vo.ItTitle;
import com.intelligence.view.service.ShowService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ShowAction extends ActionSupport implements ServletRequestAware {

	private static Log logger = LogFactory.getLog(ShowAction.class);
	private HttpServletRequest request;
	private ArrayList<ItTitle> allLists;
	private ShowService showService;
	public String list() throws Exception{
			allLists = (ArrayList<ItTitle>) showService.list();
			request.getSession().setAttribute("allLists", allLists);
			return SUCCESS;
	}
	

	public ArrayList<ItTitle> getAllLists() {
		return allLists;
	}

	public ShowService getShowService() {
		return showService;
	}

	public void setShowService(ShowService showService) {
		this.showService = showService;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
}
