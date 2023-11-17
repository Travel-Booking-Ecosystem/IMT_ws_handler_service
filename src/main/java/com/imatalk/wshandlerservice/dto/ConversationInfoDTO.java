package com.imatalk.wshandlerservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

public class ConversationInfoDTO {
    // this object only contains the information of the conversation, not the messages
    private String id;
    private String name;
    private String avatar;
    private LastMessageDTO lastMessage;
    private LocalDateTime lastUpdate; // this is the time of the last message or if there is no message, the time of the conversation creation
    private boolean unread;
    private String status;


    @Data
    public static class LastMessageDTO {
        private String id;
        private String content;
        private LocalDateTime createdAt;

    }



}
