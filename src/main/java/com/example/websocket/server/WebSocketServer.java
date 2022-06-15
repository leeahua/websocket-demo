package com.example.websocket.server;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  websocket 服务
 * @author lyh
 * @date 2022/6/15 20:07
 */
@Slf4j
@Component
@ServerEndpoint("websocket/{uid}")
public class WebSocketServer {

	public static final AtomicInteger onlineCount = new AtomicInteger(0);
	public static final Map<Long, WebSocketServer> webSocketServer = new ConcurrentHashMap<>();
	private Session session;
	private Long uid;


	@OnOpen
	public void onOpen(Session session, @PathParam("uid") Long uid){
		this.session = session;
		this.uid = uid;
	}

}
