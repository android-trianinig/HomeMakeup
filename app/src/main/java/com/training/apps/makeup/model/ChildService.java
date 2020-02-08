package com.training.apps.makeup.model;

public class ChildService {

    private String childServiceTitle;
    private int childServiceCost;
    private String childServiceCurrency;
    private String childServiceDuration;


    public ChildService(String childServiceTitle, int childServiceCost, String childServiceCurrency, String childServiceDuration) {
        this.childServiceTitle = childServiceTitle;
        this.childServiceCost = childServiceCost;
        this.childServiceCurrency = childServiceCurrency;
        this.childServiceDuration = childServiceDuration;
    }

    public String getChildServiceTitle() {
        return childServiceTitle;
    }

    public int getChildServiceCost() {
        return childServiceCost;
    }

    public String getChildServiceCurrency() {
        return childServiceCurrency;
    }

    public String getChildServiceDuration() {
        return childServiceDuration;
    }
}
