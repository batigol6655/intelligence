package com.test.dwrpush;

import java.util.Collection;
import java.util.Date;
import java.util.TimerTask;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

public class DWRService  extends TimerTask{
	private static WebContext context = null;
	/**
	 * @return 返回 context
	 */
	public static WebContext getContext() {
		if (context == null) {
			context = WebContextFactory.get();
		}
		return context;
	}


	/**
	 * @param context 设置 context 
	 */
	public static void setContext(WebContext _context) {
		if (context== null) {
			context = _context;
		}
	}


	@Override
	public void run() {
		WebContext context = getContext();
		if(context==null){
			//System.out.println("未激活Context");
			return;
		}
	//System.out.println("开始推送Context");
		Collection<ScriptSession> sessions = context.getScriptSessionsByPage("/dwrpush/index.jsp");
		if(sessions!=null && sessions.size()>0){
			String msg = new Date().getTime()+"毫秒";
			for (ScriptSession s : sessions) {// 循环所有的人,向其发送消息
				Chat chat = new Chat();
				chat.setType("3");
				chat.setMsg(" " + msg);
				chat.setSender("SYSTEM");
				ScriptBuffer buffer = new ScriptBuffer();
				buffer.appendScript("Chat.receive(");
				buffer.appendData(chat);
				buffer.appendScript(")");
				s.addScript(buffer);
			}
			
		}
	}
	
}
