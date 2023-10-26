package com.tha103.artion.websocket;

import java.io.Serializable;

public class ChatMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private Type type;
	private String sender;
	private String receiver;
	private String content;
	
	public ChatMessage() {
	}

	public ChatMessage(Type type, String sender, String receiver, String content) {
		this.type = type;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
