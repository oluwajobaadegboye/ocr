package edu.mum.cs.cs425.ocr.scheduler;

import edu.mum.cs.cs425.ocr.domain.ChatMessage;
import edu.mum.cs.cs425.ocr.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 
 * @author Cong Khanh Tran - trancongkhanh@gmail.com
 *
 *
 */
@Component
public class ChatScheduler {

	@Autowired
	private ChatService chatService;

	@Autowired
	private SimpMessagingTemplate template;

	/**
	 * Invoked after bean creation is complete, this method will schedule
	 * updatePriceAndBroacast every 1 second
	 */
	@PostConstruct
	@Scheduled(fixedDelay = 1000)
	private void broadcast() {
		ChatMessage lastMessage = chatService.getLastMessage();
		chatService.clear();
		this.template.convertAndSend("/topic/chat", lastMessage);
	}

}
