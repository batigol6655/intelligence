package com.bringspring.gateway.action;



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


import com.bringspring.common.DisposalCode;
import com.bringspring.common.Pagination;
import com.bringspring.gateway.service.showService;
import com.bringspring.gateway.vo.CarPicture;
import com.bringspring.gateway.vo.TradInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class showAction extends ActionSupport implements ServletRequestAware {

	private static Log logger = LogFactory.getLog(showAction.class);
	private TradInfo tradinfo;
	private HttpServletRequest request = null;
	private showService showService = null;
	private InputStream inputStream;
	//private ServletOutputStream out = null;   //直接在页面展示图片
	private OutputStream out = null;   //读出blob字段，并保存成jpg图片
	private byte[] bytes = null;
	Pagination traplist;
	
	public showAction(){
		if (traplist ==null )
				traplist = new Pagination();
	}
	public showService getShowService() {
		return showService;
	}


	public void setShowService(showService showService) {
		this.showService = showService;
	}
	


	/**
	 * 获取所有通道信息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception{
		
		@SuppressWarnings("rawtypes")
		//是否是实时信息
		String isNew = request.getParameter("isNew");
		//是否为入口或出口信息,in为入口，out为出口
		String inout = request.getParameter("inout");
		List<TradInfo> traplist = showService.tradList((String)request.getParameter("videoId"),isNew,inout);
		
		//将车牌类型汉字赋值
		for (TradInfo trapinfo : traplist) {
				trapinfo.setPlateType(DisposalCode.getCodeName("CAR_TYPE",trapinfo.getPlateType()));
		}
		/**
		List<CarPicture> imgList = showService.imgList(request.getParameter("tradId"));
		request.getSession().removeAttribute("imglist");
		request.getSession().setAttribute("imglist",imgList);
		*/
		
		//实时刷新数据采用ajax返回json
		if(isNew !=null && isNew.equals("new")){
			
			JSONArray jsonArray = JSONArray.fromObject(traplist);
			HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jsonArray); 
			return null;
		}else{
			//非实时刷新数据返回jsp页面
			request.getSession().removeAttribute("traplist");
			request.getSession().setAttribute("traplist", traplist);
			return SUCCESS;
		}
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
		
		traplist = showService.tradAllList(videoId,startTime,endTime,plateType,plateNo,currentPage);
		
		//将车牌类型汉字赋值
		for (Object object : traplist.getResultList()) {
			TradInfo trapinfo = (TradInfo) object;
			trapinfo.setPlateType(DisposalCode.getCodeName("CAR_TYPE",trapinfo.getPlateType()));
		}
		request.getSession().removeAttribute("traplist");
		request.getSession().setAttribute("totalRows",traplist.getTotalRows());
		request.getSession().setAttribute("totalPages",traplist.getTotalPages());
		request.getSession().setAttribute("currentPage",traplist.getCurrentPage());
		request.getSession().setAttribute("startIndex",traplist.getStartIndex());
		request.getSession().setAttribute("lastIndex",traplist.getLastIndex());
		request.getSession().setAttribute("traplist", traplist);

		return SUCCESS;
	}
	/**
	 * 按照通道id读取所有图片信息
	 * @return
	 * @throws Exception
	 */
	public String load() throws Exception{
		String[] imgStr = null;
		List<CarPicture> imgList = showService.imgList(request.getParameter("tradId"));
		
		if(imgList !=null){
			imgStr = new String[imgList.size()];
		}

		request.getSession().setAttribute("imglist",imgList);
		int i = 0;
		for (CarPicture carPicture : imgList) {
			imgStr[i]=load_img(carPicture);
			i++;
		}
		JSONArray jsonArray = JSONArray.fromObject(imgStr);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonArray); 
		return null;
	}
	
	/**
	 * 按照通道id读取详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception{
		 
		String tradId = request.getParameter("tradId");
		
		List<CarPicture> imgList = showService.imgList(tradId);
		for (CarPicture carPicture : imgList) {
			carPicture.setPictureName(load_img(carPicture));
		}
		request.getSession().setAttribute("imglist",imgList);
		
		List<TradInfo> tradinfo = showService.loadTrad(tradId);
		for (TradInfo trapinfo : tradinfo) {
			trapinfo.setPlateType(DisposalCode.getCodeName("CAR_TYPE",trapinfo.getPlateType()));
		}	
		request.getSession().setAttribute("tradinfo",tradinfo);
		return this.SUCCESS;
	}
	
	/**
	 * 按照id读取图片信息
	 * @return
	 * @throws Exception
	 */
	public String load_img(CarPicture carPicture) throws Exception{
		HttpServletResponse response  = ServletActionContext.getResponse();
		//取到图片的blob值
		byte[] blob = carPicture.getPic();
		
		//设置类型
		response.setContentType("mutipart/form-data");
		//out = response.getOutputStream();   //不保存文件直接在jsp页面显示
		//保存图片路径
		String savePath = request.getSession().getServletContext().getRealPath("/")+"img\\";
		logger.info(savePath);
		//图片以id命名
		String fileName = carPicture.getId()+".jpg";
		
		File f = new File(savePath);
		if(!f.exists()){
			f.mkdirs();
		}
		
		File file = new File(savePath,fileName);
		if(!file.exists()){
			file.createNewFile();
			out = new FileOutputStream(file);
			
			//实例化字节数组流，存储表中的照片字节
			if(blob!=null && !"".equals(blob)){
				inputStream = new ByteArrayInputStream(blob); 
				bytes = new byte[1024];
				int len = 0;
				//while(-1=inputStream.read(bytes))    //直接在页面展示图片
				while(-1!=(len=inputStream.read(bytes))){
					//out.write(bytes);
					out.write(bytes,0,len);
				}
				//out.flush();
			}
		}
		if(inputStream!=null){
			inputStream.close();
		}
		if(out!=null){
			out.close();
		}
		
		return "../img/"+fileName;
	}
	
	/**
	 * 获取首页柱图数据
	 * @return
	 * @throws Exception
	 */
	public String getInParts() throws Exception{
		
		List list = this.showService.getInParts((String) request.getParameter("in"));
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
	//	System.out.println(jsonArray);
		response.getWriter().print(jsonArray); 
		
		return null;
	}
	
	/**
	 * 获取首页饼图数据
	 * @return
	 * @throws Exception
	 */
	public String getTradInfo() throws Exception{
		List list = this.showService.getTradInfo((String) request.getParameter("in"));
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setCharacterEncoding("UTF-8");
	//	System.out.println(jsonArray);
		response.getWriter().print(jsonArray); 
		
		return null;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}
	public TradInfo getTradinfo() {
		return tradinfo;
	}
	public void setTradinfo(TradInfo tradinfo) {
		this.tradinfo = tradinfo;
	}
	public Pagination getTraplist() {
		return traplist;
	}
	public void setTraplist(Pagination traplist) {
		this.traplist = traplist;
	}
	
	
}
