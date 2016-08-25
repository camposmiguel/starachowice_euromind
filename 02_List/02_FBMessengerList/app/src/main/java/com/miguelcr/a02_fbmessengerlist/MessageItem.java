package com.miguelcr.a02_fbmessengerlist;

/**
 * Created by miguelcampos on 24/8/16.
 */
public class MessageItem {
    private String name;
    private String photo;
    private String text;
    private String time;
    private boolean online;
    private boolean unread;

    public MessageItem(String name, String photo, String text, String time, boolean online, boolean unread) {
        this.name = name;
        this.photo = photo;
        this.text = text;
        this.time = time;
        this.online = online;
        this.unread = unread;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
