package com.training.apps.makeup.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.training.apps.makeup.BR;

import java.util.HashMap;

public class CartItem extends BaseObservable {
    private HashMap<String, ChildService> cartItem = new HashMap<>();

    private int totalItemsCost;


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
        for (ChildService childService: cartItem.values()) {
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
}
