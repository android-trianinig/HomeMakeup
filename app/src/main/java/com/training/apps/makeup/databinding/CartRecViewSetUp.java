package com.training.apps.makeup.databinding;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.training.apps.makeup.Adaptre.CartRecycleAdapter;
import com.training.apps.makeup.Adaptre.NotificationRecycleAdapter;
import com.training.apps.makeup.model.ChildService;
import com.training.apps.makeup.model.MyNotification;

import java.util.ArrayList;
import java.util.List;

public class CartRecViewSetUp {
    @BindingAdapter("setItemsList")
    public static void setupRecyclerView(RecyclerView recyclerView, MutableLiveData<List<ChildService>> listMutableLiveData) {

        if (listMutableLiveData == null) {

            return;
        }

        if (recyclerView.getLayoutManager() == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setHasFixedSize(true);

        }
        if (recyclerView.getAdapter() == null) {
            CartRecycleAdapter adapter = new CartRecycleAdapter(recyclerView.getContext());
            adapter.setCartItems(listMutableLiveData);
            recyclerView.setAdapter(adapter);

        } else {
            ((CartRecycleAdapter) recyclerView.getAdapter()).setCartItems(listMutableLiveData);
        }
    }
}
