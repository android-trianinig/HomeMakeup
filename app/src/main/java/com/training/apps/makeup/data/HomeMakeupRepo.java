package com.training.apps.makeup.data;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.training.apps.makeup.R;
import com.training.apps.makeup.model.CartItem;
import com.training.apps.makeup.model.ChildService;
import com.training.apps.makeup.model.Client;
import com.training.apps.makeup.model.MyNotification;
import com.training.apps.makeup.model.MyProvider;
import com.training.apps.makeup.model.MyService;
import com.training.apps.makeup.model.Offer;
import com.training.apps.makeup.model.PreviousRequest;

import java.util.ArrayList;
import java.util.List;

public class HomeMakeupRepo {

    private static final String TAG = "HomeMakeupRepo";

    public static Client theClient;
    public static ArrayList<MyNotification> myNotifications;
    public static List<Offer> myOffers;
    public static List<MyProvider> myProviders;
    public static List<MyService> myServices;
    public static List<String> cities;
    public static List<PreviousRequest> previousRequests;
    public static List<CartItem> cartItems;


    static {
        Log.e(TAG, "static initializer: all states initialized");
        theClient = new Client("Ahmed",
                "Ahmed@gamil.com",
                "0101010101",
                "Cairo",
                "Ean-Shams Cairo",
                "212121",
                new LatLng(30.777, 30.777));


        cities = new ArrayList<>();
        cities.add("cairo");
        cities.add("alexandria");
        cities.add("Mecaa");
        cities.add("Riyadh");


        myProviders = new ArrayList<>();
        myProviders.add(new MyProvider("Hend Ali", 1, "Alexandria", "Salon/Women", 10, R.drawable.pro1, null));
        myProviders.add(new MyProvider("Sama Ibrahim", 2, "Cairo", "Salon/Women", 5, R.drawable.pro2, null));
        myProviders.add(new MyProvider("Haya Helal", 3, "Riyadh", "Salon/Women", 3, R.drawable.pro3, null));
        myProviders.add(new MyProvider("Zainab El-taweel", 4, "Mecca", "Salon/Women", 8, R.drawable.pro4, null));
        myProviders.add(new MyProvider("Elahm Ali", 5, "Medina", "Salon/Women", 9, R.drawable.pro5, null));

        myOffers = new ArrayList<>();
        myOffers.add(new Offer("offer1", 1, R.drawable.home_makeup_offer1));
        myOffers.add(new Offer("offer2", 2, R.drawable.home_makeup_offer2));
        myOffers.add(new Offer("offer3", 3, R.drawable.home_makeup_offer3));
        myOffers.add(new Offer("offer4", 4, R.drawable.home_makeup_offer4));

        myServices = new ArrayList<>();
        myServices.add(new MyService("All", new ArrayList<>() ));



        List<ChildService> henaaChildServices = new ArrayList<>();
        henaaChildServices.add(new ChildService("Black Henna", 200, "SR", "60 Minute", "Henaa"));
        henaaChildServices.add(new ChildService("Brown Henna", 250, "SR", "60 Minute", "Henaa"));
        henaaChildServices.add(new ChildService("Custom Henna", 300, "SR", "60 Minute", "Henaa"));

        myServices.add(new MyService("Henaa", henaaChildServices));


        List<ChildService> bodyCareChildServices = new ArrayList<>();
        bodyCareChildServices.add(new ChildService("Full Body Care", 800, "SR", "3 Hour", "Body Care"));
        bodyCareChildServices.add(new ChildService("Bride Body Care", 1200, "SR", "4 Hour", "Body Care"));
        bodyCareChildServices.add(new ChildService("Special Body Care", 1500, "SR", "5 Hour", "Body Care"));

        myServices.add(new MyService("Body Care", bodyCareChildServices));


        List<ChildService> hairCutChildServices = new ArrayList<>();
        hairCutChildServices.add(new ChildService("Special Hair Cut", 200, "SR", "60 Minute", "Hair Cut"));
        hairCutChildServices.add(new ChildService("New Hair Cut Style", 250, "SR", "60 Minute", "Hair Cut"));

        myServices.add(new MyService("Hair Cut", hairCutChildServices));



        List<ChildService> makeupChildServices = new ArrayList<>();
        makeupChildServices.add(new ChildService("Full Makeup", 800, "SR", "60 Minute", "Makeup"));
        makeupChildServices.add(new ChildService("Bride Makeup", 1000, "SR", "2 Hour", "Makeup"));

        myServices.add(new MyService("Makeup", makeupChildServices));

        List<ChildService> manicureChildServices = new ArrayList<>();
        manicureChildServices.add(new ChildService("Custom Manicure", 100, "SR", "60 Minute", "Manicure"));
        manicureChildServices.add(new ChildService("Full Manicure", 200, "SR", "60 Minute", "Manicure"));

        myServices.add(new MyService("Manicure",manicureChildServices ));


        myNotifications = new ArrayList<>();
        myNotifications.add(
                new MyNotification("Heba Agha",
                        "Your order is accepted",
                        "10-10-2020", "10:30",
                        ""));

        myNotifications.add(
                new MyNotification("Nagham Ali",
                        "Your order is accepted",
                        "10-10-2020",
                        "10:30",
                        ""));


        myNotifications.add(
                new MyNotification("Sally Center",
                        "Your order is accepted",
                        "10-10-2020",
                        "10:30",
                        ""));

        myNotifications.add(
                new MyNotification("Samaa Center",
                        "Your order is accepted",
                        "10-10-2020",
                        "10:30",
                        ""));

        myNotifications.add(
                new MyNotification("Zainab Ali Center",
                        "Your order is accepted",
                        "10-10-2020",
                        "10:30",
                        ""));

        previousRequests = new ArrayList<>();
        previousRequests.add(new PreviousRequest("This is Request number 1",
                "30 min",
                "Monday",
                "12-12-2020",
                "12:00PM - 1:00PM",
                800,
                "SR"));

        previousRequests.add(new PreviousRequest("This is Request number 2",
                "60 min",
                "Tuesday",
                "12-12-2020",
                "6:00PM - 10:00PM",
                400,
                "SR"));
        previousRequests.add(new PreviousRequest("This is Request number 3",
                "120 min",
                "Saturday",
                "12-12-2020",
                "8:00PM - 9:00PM",
                250,
                "SR"));
        previousRequests.add(new PreviousRequest("This is Request number 4",
                "130 min",
                "Sunday",
                "12-12-2020",
                "8:00PM - 10:00PM",
                1200,
                "SR"));
        previousRequests.add(new PreviousRequest("This is Request number 5",
                "30 min",
                "Friday",
                "12-12-2020",
                "8:00PM - 10:00PM",
                600,
                "SR"));

        cartItems = new ArrayList<>();
    }


    public static void editClientInfo(Client newClient) {
        theClient = newClient;
    }

}
