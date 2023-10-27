package com.tha103.artion.websocket;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

@ServerEndpoint("/ChatEndpoint/{username}/{role}")
public class ChatEndpoint {
	private static Session adminSession;
	private static Map<String, Session> sessionMap = new ConcurrentHashMap<>();
	private static Gson gson = new Gson();
	
	@OnOpen
	public void onOpen(
		@PathParam("username") String username,
		@PathParam("role") String role,
		Session userSession
	) {
		var chatMessage = new ChatMessage();
		if (Objects.equals(role, "Admin")) {
			adminSession = userSession;
			chatMessage.setType(Type.LIST);
			chatMessage.setContent(gson.toJson(sessionMap.keySet()));
			sendJson(adminSession, chatMessage);
		} else {
			sessionMap.put(username, userSession);
			if (adminSession != null && adminSession.isOpen()) {
				chatMessage.setType(Type.ONLINE);
				chatMessage.setSender(username);
				sendJson(adminSession, chatMessage);
			}
		}
	}

	@OnMessage
	public void onMessage(Session session, String json) {
		var chatMessage = gson.fromJson(json, ChatMessage.class);
		if (session == adminSession) {
			var receiver = chatMessage.getReceiver();
			var receiverSession = sessionMap.get(receiver);
			sendJson(receiverSession, chatMessage);
		} else {
			sendJson(adminSession, chatMessage);
		}
	}

	@OnError
	public void onError(Session userSession, Throwable e) {
		e.printStackTrace();
		sendOffline(userSession);
		removeSession(userSession);
	}

	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		sendOffline(userSession);
		removeSession(userSession);
	}
	
	private void sendJson(Session session, Serializable serial) {
		if (session != null && session.isOpen()) {
			session.getAsyncRemote().sendText(gson.toJson(serial));
		}
	}
	
	private void removeSession(Session session) {
		if (session == adminSession) {
			adminSession = null;
		} else {
			sessionMap.values().remove(session);
		}
	}
	
	private void sendOffline(Session session) {
		if (adminSession != null && adminSession.isOpen()) {
			var chatMessage = new ChatMessage();
			chatMessage.setType(Type.OFFLINE);
			chatMessage.setSender(getUsernameBySession(session));
			adminSession.getAsyncRemote().sendText(gson.toJson(chatMessage));
		}
	}
	
	private String getUsernameBySession(Session session) {
		for (var entry : sessionMap.entrySet()) {
			if (session == entry.getValue()) {
				return entry.getKey();
			}
		}
		return null;
	}
}
