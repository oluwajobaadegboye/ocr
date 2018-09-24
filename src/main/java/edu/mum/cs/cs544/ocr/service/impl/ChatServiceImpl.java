package edu.mum.cs.cs544.ocr.service.impl;


import edu.mum.cs.cs544.ocr.domain.ChatMessage;
import edu.mum.cs.cs544.ocr.service.ChatService;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
	private ChatMessage lastMessage = new ChatMessage();
	@Override
	public ChatMessage getLastMessage() {
		
		return lastMessage;
	}

	@Override
	public void save(ChatMessage message) {
		lastMessage = message;
	}

	@Override
	public void clear() {
		lastMessage.clear();
	}
}
