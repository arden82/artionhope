package com.tha103.artion.websocket;

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

@ServerEndpoint("/ChatEndpoint/{username}")
public class ChatEndpoint {
	private static Session adminSession;
	private static Map<String, Session> sessionMap = new ConcurrentHashMap<>();
	private static Gson gson = new Gson();
	
	@OnOpen
	public void onOpen(@PathParam("username") String username, Session userSession) {
		if (Objects.equals(username, "Admin")) {
			adminSession = userSession;
		} else {
			sessionMap.put(username, userSession);
			if (adminSession != null && adminSession.isOpen()) {
				var chatMessage = new ChatMessage();
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
	
	private void sendJson(Session session, Object obj) {
		if (session != null && session.isOpen()) {
			session.getAsyncRemote().sendText(gson.toJson(obj));
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
