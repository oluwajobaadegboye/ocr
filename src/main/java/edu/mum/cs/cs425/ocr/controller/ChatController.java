package edu.mum.cs.cs425.ocr.controller;


import edu.mum.cs.cs425.ocr.domain.ChatMessage;
import edu.mum.cs.cs425.ocr.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author Cong Khanh Tran - trancongkhanh@gmail.com
 *
 *
 */
@Controller
public class ChatController {
	@Autowired
	ChatService chatService;

	/**
	 * WebSocket Handler to add one stock
	 */
	@MessageMapping("/send")
	@SendTo("/topic/chat")
	public ChatMessage addMessage(ChatMessage message) {
		chatService.save(message);
		return message;
	}
}