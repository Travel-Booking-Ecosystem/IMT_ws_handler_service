package com.imatalk.wshandlerservice.listener;

import com.imatalk.wshandlerservice.events.NewConversationEvent;
import com.imatalk.wshandlerservice.events.NewFriendRequestEvent;
import com.imatalk.wshandlerservice.events.NewMessageEvent;
import com.imatalk.wshandlerservice.events.NewNotificationEvent;
import com.imatalk.wshandlerservice.service.WSHandlerService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppEventListener {

    private final String NEW_CONVERSATION_TOPIC = "new-conversation";
    private final String NEW_FRIEND_REQUEST_TOPIC = "new-friend-request";
    private final String NEW_NOTIFICATION_TOPIC = "new-notification";
    private final String NEW_MESSAGE_TOPIC = "new-message";

    private final WSHandlerService wsHandlerService;
    @KafkaListener(topics = NEW_CONVERSATION_TOPIC, containerFactory = "appEventKafkaListenerContainerFactory")
    public void consumeNewConversation(ConsumerRecord<String, NewConversationEvent> event) {
        System.out.println("New Conversation: " + event.value());
        wsHandlerService.sendNewConversationEvent(event.value());
    }

    @KafkaListener(topics = NEW_FRIEND_REQUEST_TOPIC, containerFactory = "appEventKafkaListenerContainerFactory")
    public void consumeNewFriendRequest(ConsumerRecord<String, NewFriendRequestEvent> event) {
        System.out.println("New Friend Request: " + event.value());
        wsHandlerService.sendNewFriendRequestEvent(event.value());
    }

    @KafkaListener(topics = NEW_NOTIFICATION_TOPIC, containerFactory = "appEventKafkaListenerContainerFactory")
    public void consumeNewNotification(ConsumerRecord<String, NewNotificationEvent> event) {
        System.out.println("New Notification: " + event.value());
        wsHandlerService.sendNewNotificationEvent(event.value());
    }

    @KafkaListener(topics = NEW_MESSAGE_TOPIC, containerFactory = "appEventKafkaListenerContainerFactory")
    public void consumeNewMessage(ConsumerRecord<String, NewMessageEvent> event) {
        System.out.println("New Message: " + event.value());
        wsHandlerService.sendNewMessageEvent(event.value());
    }


}
