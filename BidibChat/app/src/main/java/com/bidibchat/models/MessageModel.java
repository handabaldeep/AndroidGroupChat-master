package com.bidibchat.models;

import java.text.SimpleDateFormat;

/**
 * Created by tekvy on 17/9/15.
 */
public class MessageModel {

    private String text;
    private SimpleDateFormat timeStamp;
    private String messageImageUrl;
    private String senderName;

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }



    public String getMessageImageUrl() {
        return messageImageUrl;
    }

    public void setMessageImageUrl(String messageImageUrl) {
        this.messageImageUrl = messageImageUrl;
    }

    public SimpleDateFormat getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(SimpleDateFormat timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
