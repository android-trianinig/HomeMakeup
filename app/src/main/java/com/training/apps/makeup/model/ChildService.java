package com.training.apps.makeup.model;

public class ChildService {

    private String childServiceTitle;
    private int childServiceCost;
    private String childServiceCurrency;
    private String childServiceDuration;
    private boolean isChecked;
    private String parent;


    public ChildService(String childServiceTitle, int childServiceCost, String childServiceCurrency, String childServiceDuration, String parent) {
        this.childServiceTitle = childServiceTitle;
        this.childServiceCost = childServiceCost;
        this.childServiceCurrency = childServiceCurrency;
        this.childServiceDuration = childServiceDuration;
        this.parent = parent;
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

    public String getParent() {
        return parent;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChildService that = (ChildService) o;
        return parent.equals(that.parent);
    }

    @Override
    public int hashCode() {
        return parent.hashCode() + 56;
    }
}
