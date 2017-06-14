package org.mina_demo;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class TimeClientHander implements IoHandler {

	public void exceptionCaught(IoSession arg0, Throwable arg1) throws Exception {
		arg1.printStackTrace();
	}

	public void inputClosed(IoSession arg0) throws Exception {
		
	}

	public void messageReceived(IoSession arg0, Object message) throws Exception {
		System.out.println("client接受信息:" + message.toString());
	}

	public void messageSent(IoSession arg0, Object message) throws Exception {
		System.out.println("client发送信息" + message.toString());
	}

	public void sessionClosed(IoSession session) throws Exception {
		System.out.println("client与:" + session.getRemoteAddress().toString() + "断开连接");
	}

	public void sessionCreated(IoSession session) throws Exception {
		System.out.println("client与:" + session.getRemoteAddress().toString() + "建立连接");
	}

	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		System.out.println("IDLE " + session.getIdleCount(status));
	}

	public void sessionOpened(IoSession arg0) throws Exception {
		System.out.println("打开连接");
	}
}
