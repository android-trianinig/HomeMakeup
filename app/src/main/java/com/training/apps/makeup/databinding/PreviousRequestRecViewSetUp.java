package com.training.apps.makeup.databinding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.training.apps.makeup.Adaptre.PreviousReqRecycleAdapter;
import com.training.apps.makeup.model.PreviousRequest;

import java.util.List;

public class PreviousRequestRecViewSetUp {




    @BindingAdapter("setPrevReqList")
    public static void setupRecyclerView(RecyclerView recyclerView, List<PreviousRequest> previousRequests) {
        if (previousRequests == null || previousRequests.isEmpty()) {
            return;
        }
        if (recyclerView.getLayoutManager() == null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setHasFixedSize(true);

        }
        if (recyclerView.getAdapter() == null) {
            PreviousReqRecycleAdapter adapter = new PreviousReqRecycleAdapter(recyclerView.getContext());
            adapter.setPreviousRequests(previousRequests);
            recyclerView.setAdapter(adapter);

        } else {
            ((PreviousReqRecycleAdapter) recyclerView.getAdapter()).setPreviousRequests(previousRequests);
        }
    }
}
