package com.imatalk.wshandlerservice.events;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class NewConversationEvent {
    private String userId;
    private ConversationInfo conversationInfo;


    @Data
    public static class ConversationInfo {
        // this object only contains the information of the conversation, not the messages
        private String id;
        private String name;
        private String avatar;
        private LastMessage lastMessage;
        private LocalDateTime lastUpdate; // this is the time of the last message or if there is no message, the time of the conversation creation
        private boolean unread;
        private String status;

    }

    @Data
    public static class LastMessage {
        private String id;
        private String content;
        private LocalDateTime createdAt;

    }
}
