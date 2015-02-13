/** 修改历史
 *   日期               作者          修改内容
 * -----------------------------------------------------------------------------
 * 2011-01-9            李小强         创建CLASS
 */
package com.test.dwrpush;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * <p>description:，</p>
 * <p>Title</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: </p> 
 * <p>@author 李小强 leaderbird</p> 
 * <p>@version 1.1</p>
 * <p>@date : 2011-01-9</p>
 */
public class Chat {
	private String sender;
	private String msg;
	private String type;
	private int state;
	
	public Chat() {
		super();
	}

	public Chat(String sender, String msg, String type, int state) {
		super();
		this.sender = sender;
		this.msg = msg;
		this.type = type;
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("state", this.state).append(
				"type", this.type).append("msg", this.msg).append("sender",
				this.sender).toString();
	}

}
