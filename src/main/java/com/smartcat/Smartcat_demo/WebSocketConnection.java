package com.smartcat.Smartcat_demo;

import java.net.URI;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.smartcat.Smartcat_demo.kafka.Producer;

@Service
public class WebSocketConnection extends TextWebSocketHandler {

	private static final String URL = "wss://ws.kupujemprodajem.com/wsfeed?get=combined";
	private WebSocketSession clientSession;

	public WebSocketSession getClientSession() {
		return clientSession;
	}

	public WebSocketConnection() throws ExecutionException, InterruptedException {
		StandardWebSocketClient webSocketClient = new StandardWebSocketClient();
		try {
			this.clientSession = webSocketClient.doHandshake(this, new WebSocketHttpHeaders(), URI.create(URL)).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) {
		Producer.sendMessage(message.getPayload());
		System.out.println("Poruka za topic: " + message.getPayload());
	}
}
