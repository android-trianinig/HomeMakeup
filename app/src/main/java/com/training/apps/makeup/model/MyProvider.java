package com.training.apps.makeup.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.training.apps.makeup.BR;

import java.util.List;

public class MyProvider extends BaseObservable {

    private String providerName;
    private int providerId;
    private String providerCity;
    private String providerType;
    private double providerRate;
    private int providerImage;
    private String providerPhoneNumber;
    private String providerEmail;
    private String providerLocation;
    private List<MyService> providerServices;
    private String providerPassword;

    public MyProvider() {
    }

    public MyProvider(String providerName, int providerId, String providerCity, String providerType, double providerRate, int providerImage, List<MyService> providerServices) {
        this.providerName = providerName;
        this.providerId = providerId;
        this.providerCity = providerCity;
        this.providerType = providerType;
        this.providerRate = providerRate;
        this.providerImage = providerImage;
        this.providerServices = providerServices;
    }

    @Bindable
    public String getProviderName() {
        return providerName;
    }

    @Bindable
    public int getProviderId() {
        return providerId;
    }

    @Bindable
    public String getProviderCity() {
        return providerCity;
    }

    @Bindable
    public String getProviderType() {
        return providerType;
    }

    @Bindable
    public double getProviderRate() {
        return providerRate;
    }

    @Bindable
    public int getProviderImage() {
        return providerImage;
    }

    @Bindable
    public String getProviderPhoneNumber() {
        return providerPhoneNumber;
    }

    @Bindable
    public String getProviderEmail() {
        return providerEmail;
    }

    @Bindable
    public String getProviderLocation() {
        return providerLocation;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
        notifyPropertyChanged(BR.providerName);
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
        notifyPropertyChanged(BR.providerId);
    }

    public void setProviderCity(String providerCity) {
        this.providerCity = providerCity;
        notifyPropertyChanged(BR.providerCity);
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
        notifyPropertyChanged(BR.providerType);
    }

    public void setProviderRate(double providerRate) {
        this.providerRate = providerRate;
        notifyPropertyChanged(BR.providerRate);
    }

    public void setProviderImage(int providerImage) {
        this.providerImage = providerImage;
        notifyPropertyChanged(BR.providerImage);
    }


    public void setProviderPhoneNumber(String providerPhoneNumber) {
        this.providerPhoneNumber = providerPhoneNumber;
        notifyPropertyChanged(BR.providerPhoneNumber);
    }

    public void setProviderEmail(String providerEmail) {
        this.providerEmail = providerEmail;
        notifyPropertyChanged(BR.providerEmail);
    }

    public void setProviderLocation(String providerLocation) {
        this.providerLocation = providerLocation;
        notifyPropertyChanged(BR.providerLocation);
    }

    @Bindable
    public List<MyService> getProviderServices() {
        return providerServices;
    }

    public void setProviderServices(List<MyService> providerServices) {
        this.providerServices = providerServices;
        notifyPropertyChanged(BR.providerServices);
    }

    @Bindable
    public String getProviderPassword() {
        return providerPassword;
    }

    public void setProviderPassword(String providerPassword) {
        this.providerPassword = providerPassword;
        notifyPropertyChanged(BR.providerPassword);
    }
}
