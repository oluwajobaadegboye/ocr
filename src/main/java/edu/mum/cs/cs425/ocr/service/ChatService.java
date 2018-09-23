package edu.mum.cs.cs425.ocr.service;


import edu.mum.cs.cs425.ocr.domain.ChatMessage;

public interface ChatService {
	ChatMessage getLastMessage();
	void save(ChatMessage message);
	void clear();
}
