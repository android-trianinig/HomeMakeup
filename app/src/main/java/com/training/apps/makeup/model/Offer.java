package com.training.apps.makeup.model;

public class Offer {
    private String offerName;
    private int offerId;
    private int offerImage;

    public Offer(String offerName, int offerId, int offerImage) {
        this.offerName = offerName;
        this.offerId = offerId;
        this.offerImage = offerImage;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(int offerImage) {
        this.offerImage = offerImage;
    }
}
