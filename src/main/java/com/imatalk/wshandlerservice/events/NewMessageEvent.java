package com.imatalk.wshandlerservice.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class NewMessageEvent {
    private List<String> conversationMemberIds;
    private Message message;

    @Data
    public static class Message {
        private String id;
        private String senderId;
        private String content;
        private String createdAt;
        private String conversationId;
        private long messageNo;
        private String repliedMessageId; // this is the id of the message that this message is replying to
    }

}
