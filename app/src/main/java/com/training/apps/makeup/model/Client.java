package com.training.apps.makeup.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.android.gms.maps.model.LatLng;
import com.training.apps.makeup.BR;

public class Client extends BaseObservable {

    private String clientName;
    private String clientEmail;
    private String clientPhoneNumber;
    private String clientCity;
    private String clientAddress;
    private String clientPassword;
    private LatLng latLng;


    public Client() {
    }

    public Client(String clientName, String clientEmail, String clientPhoneNumber, String clientCity, String clientAddress, String clientPassword, LatLng latLng) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientCity = clientCity;
        this.clientAddress = clientAddress;
        this.clientPassword = clientPassword;
        this.latLng = latLng;
    }

    @Bindable
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
        notifyPropertyChanged(BR.clientName);
    }

    @Bindable
    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
        notifyPropertyChanged(BR.clientEmail);
    }

    @Bindable
    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
        notifyPropertyChanged(BR.clientPhoneNumber);
    }

    @Bindable
    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
        notifyPropertyChanged(BR.clientCity);
    }

    @Bindable
    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
        notifyPropertyChanged(BR.clientAddress);
    }

    @Bindable
    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
        notifyPropertyChanged(BR.clientPassword);
    }

    @Bindable
    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
        notifyPropertyChanged(BR.latLng);
    }
}


