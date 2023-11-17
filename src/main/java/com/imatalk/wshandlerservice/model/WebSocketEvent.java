package com.imatalk.wshandlerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebSocketEvent {
    private WebSocketEventName name;
    private Object data;

    public enum WebSocketEventName {
        NEW_MESSAGE,
        NEW_FRIEND_REQUEST,
        NEW_NOTIFICATION,
        NEW_CONVERSATION
    }

}
