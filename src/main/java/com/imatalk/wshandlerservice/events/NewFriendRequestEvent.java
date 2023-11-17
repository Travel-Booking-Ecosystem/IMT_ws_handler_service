package com.imatalk.wshandlerservice.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class NewFriendRequestEvent {

    private String receiverId;
    private FriendRequest friendRequest;

    @Data
    public static class FriendRequest {
        private String id;
        private User sender;
        private LocalDateTime createdAt;
        private boolean isAccepted;
    }

    @Data
    public static class User {
        private String id;
        private String username; // this is unique, like @john_due21
        private String displayName;
        private String email;
        private String avatar;
    }
}
