package com.training.apps.makeup.model;

public class MyNotification {
    private String title;
    private String content;
    private String date;
    private String time;
    private String imageUrl;

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public MyNotification(String title, String content, String date, String time, String imageUrl) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.time = time;
        this.imageUrl = imageUrl;
    }

    public MyNotification() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
