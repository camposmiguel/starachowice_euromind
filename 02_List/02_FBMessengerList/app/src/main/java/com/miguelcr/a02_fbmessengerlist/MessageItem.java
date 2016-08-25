package com.miguelcr.a02_fbmessengerlist;

/**
 * Created by miguelcampos on 24/8/16.
 */
public class MessageItem {
    private String name;
    private String photo;
    private String text;
    private String time;

    public MessageItem(String name, String photo, String text, String time) {
        this.name = name;
        this.photo = photo;
        this.text = text;
        this.time = time;
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
