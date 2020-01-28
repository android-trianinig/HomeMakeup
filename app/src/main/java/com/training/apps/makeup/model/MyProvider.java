package com.training.apps.makeup.model;

public class MyProvider {
    private String providerName;
    private int providerId;
    private String providerCity;
    private String providerType;
    private double providerRate;
    private int providerImage;

    public MyProvider(String providerName, int providerId, String providerCity, String providerType, double providerRate, int providerImage) {
        this.providerName = providerName;
        this.providerId = providerId;
        this.providerCity = providerCity;
        this.providerType = providerType;
        this.providerRate = providerRate;
        this.providerImage = providerImage;
    }

    public String getProviderName() {
        return providerName;
    }

    public int getProviderId() {
        return providerId;
    }

    public String getProviderCity() {
        return providerCity;
    }

    public String getProviderType() {
        return providerType;
    }

    public double getProviderRate() {
        return providerRate;
    }

    public int getProviderImage() {
        return providerImage;
    }
}
