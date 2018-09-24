package edu.mum.cs.cs544.ocr.service;


import edu.mum.cs.cs544.ocr.domain.ChatMessage;

public interface ChatService {
	ChatMessage getLastMessage();
	void save(ChatMessage message);
	void clear();
}
