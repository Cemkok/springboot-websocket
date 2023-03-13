package com.springboot.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springboot.websocket.model.WsMessage;

@Controller
//localhost default olarak disabled geldiği için @CrossOrigini açıyoruz
@CrossOrigin
public class ChatController {
	/**
	 *Mesajların yönlendirilmesi için ya anatasyonla yapılır ya da messagingtemplate kullanılır 
	 */
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	
	@MessageMapping("/chat")
	//@SendTo("/topic")
	//@SendToUser   
	                         //@Payload;  body den alır   
	public void chatEndPoint(@Payload WsMessage wsMessage) {
		System.out.println(wsMessage);
		messagingTemplate.convertAndSend("/topic", wsMessage);
		
		
	}
	
	

}
