package org.mina_demo;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * @author Pinky Lam 908716835@qq.com
 * @date 2017年6月14日 下午5:52:15
 */
public class MinaTimeServer {

	private static final int PORT = 9123;

	public static void main(String[] args) throws IOException {

		IoAcceptor acceptor = new NioSocketAcceptor();
		// 这个过滤器用来记录所有的信息，比如创建session(会话)，接收消息，发送消息，关闭会话等
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		// 用来转换二进制或协议的专用数据到消息对象中
		acceptor.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

		// 实时处理客户端的连接和请求
		acceptor.setHandler(new TimeServerHandler());
		acceptor.getSessionConfig().setReadBufferSize(2048);
		// 方法将定时调用一次会话，保持空闲状态。来设定时间间隔。
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		acceptor.bind(new InetSocketAddress(PORT));
	}

}
