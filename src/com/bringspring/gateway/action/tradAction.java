package com.bringspring.gateway.action;



import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
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


import com.bringspring.gateway.service.tradService;
import com.bringspring.gateway.vo.CarPicture;
import com.bringspring.gateway.vo.Trad;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class tradAction extends ActionSupport implements ServletRequestAware {

	private static Log logger = LogFactory.getLog(tradAction.class);
	private Trad trad;
	private HttpServletRequest request = null;
	private tradService tradService = null;
	
	
	public tradAction(){
		
	}
	public tradService getTradService() {
		return tradService;
	}


	public void setTradService(tradService tradService) {
		this.tradService = tradService;
	}
	


	/**
	 * 获取所有通道信息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		
		@SuppressWarnings("rawtypes")
		List traplist = tradService.tradList();
		
		request.getSession().removeAttribute("tlist");
		request.getSession().setAttribute("tlist", traplist);
		return SUCCESS;
	}
	
	/**
	 * 按照通道id读取所有图片信息
	 * @return
	 * @throws Exception
	 */
	public String load() throws Exception{
		String[] imgStr = null;
		List<CarPicture> imgList = tradService.imgList(request.getParameter("tradId"));
		if(imgList !=null){
			imgStr = new String[imgList.size()];
		}

		request.getSession().setAttribute("imglist",imgList);
		
		return null;
	}
	
	/**
	 * 按照通道id读取详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception{
		 
		String tradId = request.getParameter("tradId");
		List<CarPicture> imgList = tradService.imgList(tradId);
		
		
		request.getSession().setAttribute("trad",trad);
		return this.SUCCESS;
	}
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}

	
}
