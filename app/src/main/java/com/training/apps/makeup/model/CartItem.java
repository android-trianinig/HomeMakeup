package com.training.apps.makeup.model;

import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.training.apps.makeup.BR;

import java.util.HashMap;

public class CartItem extends BaseObservable {

    private HashMap<String, ChildService> cartItem = new HashMap<>();
    private int totalItemsCost;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private String dayText;


    @Bindable
    public HashMap<String, ChildService> getCartItem() {
        return cartItem;
    }

    public void setCartItem(HashMap<String, ChildService> cartItem) {
        this.cartItem = cartItem;
        notifyPropertyChanged(BR.cartItem);
    }

    public void addItem(String parent, ChildService childService) {
        cartItem.put(parent, childService);
        notifyPropertyChanged(BR.cartItem);
        updateCost();
    }

    public void updateCost() {
        int newTotalCost = 0;
        for (ChildService childService : cartItem.values()) {
            newTotalCost += childService.getChildServiceCost();
        }
        setTotalItemsCost(newTotalCost);
    }

    @Bindable
    public int getTotalItemsCost() {
        return totalItemsCost;
    }

    public void setTotalItemsCost(int totalItemsCost) {
        this.totalItemsCost = totalItemsCost;
        notifyPropertyChanged(BR.totalItemsCost);
    }

    public String getItemsCurrency() {
        return "SR";
    }

    @Bindable
    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
        notifyPropertyChanged(BR.year);
    }

    @Bindable
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
        notifyPropertyChanged(BR.month);
    }

    @Bindable
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
        notifyPropertyChanged(BR.day);
    }

    @Bindable
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        notifyPropertyChanged(BR.hour);
    }

    @Bindable
    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        notifyPropertyChanged(BR.minute);
    }

    @Bindable
    public String getDayText() {
        return dayText;
    }

    public void setDayText(String dayText) {
        this.dayText = dayText;
        notifyPropertyChanged(BR.dayText);
    }
}
