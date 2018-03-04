package com.example.android.mentalhealthbot;

/**
 * Created by shomarimalcolm on 2018-03-03.
 */

public class UserMessage {

    private String mMessage;
    private Boolean mIsUser;
    private long mCreatedAt;

    public UserMessage(String message, Boolean isUser, Long createdAt){
        mMessage = message;
        mIsUser = isUser;
        mCreatedAt = createdAt;

    }

    public String getMessage() {
        return mMessage;
    }

    public Boolean getIsUser() {
        return mIsUser;
    }

    public long getCreatedAt() {
        return mCreatedAt;
    }
}
