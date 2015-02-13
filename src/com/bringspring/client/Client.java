package com.bringspring.client;

import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: HeartBeatTestClient
 * @Description: MINA心跳测试客户端,仅供测试 client空闲时每隔N秒向服务器发送心跳包，如返回超时，发出提示
 * 
 */
public class Client extends Thread{

	private static final Logger LOG = LoggerFactory
			.getLogger(Client.class);

	private int PORT = 33002;
	/** 30秒后超时 */
	private static final int IDELTIMEOUT = 60;
	/** 15秒发送一次心跳包 */
	private static final int HEARTBEATRATE = 5;
	/** 心跳包内容 */
	private static final byte[] HEARTBEATREQUEST = {(byte)0xaa,(byte)0x55,(byte)0xaa,(byte)0x55,(byte)0x10,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa,(byte)0xaa};
	
	private String IPADDRESS = "172.20.200.154";

	private static NioSocketConnector connector;
	private static IoHandler handler = new ClientHandler();
	
	public Client(String ip, int port)
	{
		this.IPADDRESS = ip;
		this.PORT = port;
	}
	
	public void run(){
		this.main();
	}
	public void main() {
		connector = new NioSocketConnector();
//		connector.getFilterChain().addLast("log", new LoggingFilter());
		connector.getFilterChain().addLast("myChin", new ProtocolCodecFilter(
				new MessageCodecFactory()));
		connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,
				IDELTIMEOUT);
//		connector.setConnectTimeout(30);
		/** 主角登场 */

		KeepAliveMessageFactory heartBeatFactory = new KeepAliveMessageFactoryImpl();
//		KeepAliveRequestTimeoutHandler heartBeatHandler = new KeepAliveRequestTimeoutHandlerImpl();
		KeepAliveFilter heartBeat = new KeepAliveFilter(heartBeatFactory,
				IdleStatus.READER_IDLE, KeepAliveRequestTimeoutHandler.DEAF_SPEAKER);
		/** 是否回发 */
		heartBeat.setForwardEvent(true);
		/** 发送频率 */
		heartBeat.setRequestInterval(HEARTBEATRATE);
		connector.getSessionConfig().setKeepAlive(true);
		connector.getFilterChain().addLast(IPADDRESS, heartBeat);

		/** *********** */
		connector.setHandler(handler);
		connector.connect(new InetSocketAddress(IPADDRESS, PORT));
//		connector.getCloseFuture().awaitUninterruptibly();
		LOG.info(IPADDRESS+"客户端已连接上！");
	}

	/***
	 * @ClassName: KeepAliveMessageFactoryImpl
	 * @Description: 内部类，实现心跳工厂
	 * 
	 */
	private static class KeepAliveMessageFactoryImpl implements
			KeepAliveMessageFactory {
		@Override
		public Object getRequest(IoSession session) {
//			LOG.info("返回预设语句" + HEARTBEATREQUEST);
			/** 返回预设语句 */
			return null;
		}

		@Override
		public Object getResponse(IoSession session, Object request) {
//			LOG.info("得到返回");
			return HEARTBEATREQUEST;
		}

		@Override
		public boolean isRequest(IoSession session, Object message) {
//			LOG.info("11"+message.equals("OK"));
//			LOG.info("是否是心跳包1: " + message);
			
			if(message.equals("OK"))
				return true;
			return false;
		}

		@Override
		public boolean isResponse(IoSession session, Object message) {
				return false;
		}

	}

	/***
	 * @ClassName: KeepAliveRequestTimeoutHandlerImpl
	 * @Description: 当心跳超时时的处理，也可以用默认处理 这里like
	 *               KeepAliveRequestTimeoutHandler.LOG的处理
	 * 
	 */
	private static class KeepAliveRequestTimeoutHandlerImpl implements
			KeepAliveRequestTimeoutHandler {
		@Override
		public void keepAliveRequestTimedOut(KeepAliveFilter filter,
				IoSession session) throws Exception {
			((Logger) LOG).info("心跳超时！");
		}

	}
}
