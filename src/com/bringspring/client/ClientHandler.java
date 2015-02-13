package com.bringspring.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: HeartBeatServerHandler
 * @Description: 心跳测试客户端消息处理
 * 
 */
public class ClientHandler extends IoHandlerAdapter {

	private static final Logger LOG = LoggerFactory
			.getLogger(ClientHandler.class);

	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		LOG.info("捕获异常");
		cause.printStackTrace();
	}

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		String msg = message.toString();
//		LOG.info("客户端接收到的消息是："+msg);
		super.messageReceived(session, message);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {		
//		LOG.info("客户端发送消息");
		super.messageSent(session, message);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		LOG.info("session被关闭");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
//		LOG.info("session正空闲" + status.toString());
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		LOG.info("session连接被打开");
	}
}
