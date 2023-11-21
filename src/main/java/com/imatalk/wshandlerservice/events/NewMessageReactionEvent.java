package com.imatalk.wshandlerservice.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewMessageReactionEvent {
    private List<String> conversationMemberIds;
    private MessageReactionDTO messageReaction;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MessageReactionDTO {
        private String messageId;
        private String messageOwnerId;
        private Conversation conversation;
        private ReactionInformation reactionInformation;
        private boolean unReact;
    }

    @Data
    public static class ReactionInformation {
        private String reactorId;
        private String reactorName;
        private MessageReaction reaction;
        private LocalDateTime reactedAt;
    }

    @Data
    public static class Conversation {
        // this object only contains the information of the conversation, not the messages
        private String conversationId;
        private String conversationName;
        private String conversationAvatar;
    }

    public enum MessageReaction {
        LIKE,
        LOVE,
        HAHA,
        WOW,
        SAD,
        ANGRY
    }
}

