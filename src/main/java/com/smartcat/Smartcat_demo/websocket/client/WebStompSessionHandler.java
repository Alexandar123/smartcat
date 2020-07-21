package com.smartcat.Smartcat_demo.websocket.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.lang.reflect.Type;
public class WebStompSessionHandler implements WebSocketHandler {
	private Logger logger = LogManager.getLogger(WebStompSessionHandler.class);

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//session.sendMessage(message);
		System.out.println("Konektnovan" + session.getHandshakeHeaders());
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	} 

}
