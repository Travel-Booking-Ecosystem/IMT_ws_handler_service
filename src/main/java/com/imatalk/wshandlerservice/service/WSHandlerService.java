package com.imatalk.wshandlerservice.service;

import com.imatalk.wshandlerservice.events.*;
import com.imatalk.wshandlerservice.model.WebSocketEvent;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import static com.imatalk.wshandlerservice.model.WebSocketEvent.WebSocketEventName.*;

@Service
@RequiredArgsConstructor
public class WSHandlerService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Value("${USER_ENDPOINT}")
    private String USER_ENDPOINT; // = topic/user

    public void sendNewConversationEvent(NewConversationEvent event) {
        String destination = USER_ENDPOINT + "/" + event.getUserId();
        WebSocketEvent webSocketEvent = WebSocketEvent.builder()
                        .name(NEW_CONVERSATION)
                        .data(event.getConversationInfo())
                        .build();
        simpMessagingTemplate.convertAndSend(destination, webSocketEvent);

    }

    public void sendNewFriendRequestEvent(NewFriendRequestEvent event) {
        String destination = USER_ENDPOINT + "/" + event.getReceiverId();
        WebSocketEvent webSocketEvent = WebSocketEvent.builder()
                .name(NEW_FRIEND_REQUEST)
                .data(event.getFriendRequest())
                .build();
        simpMessagingTemplate.convertAndSend(destination, webSocketEvent);
    }

    public void sendNewNotificationEvent(NewNotificationEvent event) {
        String destination = USER_ENDPOINT + "/" + event.getUserId();
        WebSocketEvent webSocketEvent = WebSocketEvent.builder()
                .name(NEW_NOTIFICATION)
                .data(event.getNotification())
                .build();
        simpMessagingTemplate.convertAndSend(destination, webSocketEvent);

    }

    public void sendNewMessageEvent(NewMessageEvent event) {
        // send to all members in the conversation
        WebSocketEvent webSocketEvent = WebSocketEvent.builder()
                .name(NEW_MESSAGE)
                .data(event.getMessage())
                .build();

        for (String memberId : event.getConversationMemberIds()) {
            String destination = USER_ENDPOINT + "/" + memberId;
            simpMessagingTemplate.convertAndSend(destination, webSocketEvent);
        }
    }

    public void sendNewMessageReactionEvent(NewMessageReactionEvent event) {
        // send to all members in the conversation
        WebSocketEvent webSocketEvent = WebSocketEvent.builder()
                .name(NEW_MESSAGE_REACTION)
                .data(event.getMessageReaction())
                .build();

        for (String memberId : event.getConversationMemberIds()) {
            String destination = USER_ENDPOINT + "/" + memberId;
            simpMessagingTemplate.convertAndSend(destination, webSocketEvent);
        }
    }

    //TODO: 4 methods to send websocket event to client
}
