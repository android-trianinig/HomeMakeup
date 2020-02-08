package com.training.apps.makeup.model;

public class PreviousRequest {


    private String reqTitle;
    private String reqDuration;
    private String reqDayTxt;
    private String reqDayNum;
    private String fromTo;
    private int reqCost;
    private String reqCurrency;

    public PreviousRequest(String reqTitle, String reqDuration, String reqDayTxt, String reqDayNum, String fromTo, int reqCost, String reqCurrency) {
        this.reqTitle = reqTitle;
        this.reqDuration = reqDuration;
        this.reqDayTxt = reqDayTxt;
        this.reqDayNum = reqDayNum;
        this.fromTo = fromTo;
        this.reqCost = reqCost;
        this.reqCurrency = reqCurrency;
    }

    public String getReqTitle() {
        return reqTitle;
    }

    public String getReqDuration() {
        return reqDuration;
    }

    public String getReqDayTxt() {
        return reqDayTxt;
    }

    public String getReqDayNum() {
        return reqDayNum;
    }

    public String getFromTo() {
        return fromTo;
    }

    public int getReqCost() {
        return reqCost;
    }

    public String getReqCurrency() {
        return reqCurrency;
    }
}
