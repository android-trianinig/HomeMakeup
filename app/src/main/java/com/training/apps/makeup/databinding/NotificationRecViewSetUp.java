package com.training.apps.makeup.databinding;

import android.util.Log;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.training.apps.makeup.Adaptre.NotificationRecycleAdapter;
import com.training.apps.makeup.model.MyNotification;

import java.util.ArrayList;
import java.util.List;

public class NotificationRecViewSetUp {
    private static final String TAG = "NotificationRecViewSetU";
    @BindingAdapter("setNotificationList")
    public static void setupRecyclerView(RecyclerView recyclerView, ArrayList<MyNotification> myNotifications) {
        if (myNotifications == null || myNotifications.isEmpty()) {
            return;
        }
        if (recyclerView.getLayoutManager() == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setHasFixedSize(true);

        }
        if (recyclerView.getAdapter() == null) {
            NotificationRecycleAdapter adapter = new NotificationRecycleAdapter(recyclerView.getContext());
            adapter.setMyNotificationList(myNotifications);
            recyclerView.setAdapter(adapter);

        } else {
            ((NotificationRecycleAdapter) recyclerView.getAdapter()).setMyNotificationList(myNotifications);
        }
    }
}
