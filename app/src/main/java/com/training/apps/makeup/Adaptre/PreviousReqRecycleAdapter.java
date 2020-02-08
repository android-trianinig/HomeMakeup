package com.training.apps.makeup.Adaptre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.training.apps.makeup.R;
import com.training.apps.makeup.databinding.PreviousReqListItemBinding;
import com.training.apps.makeup.model.PreviousRequest;

import java.util.List;

public class PreviousReqRecycleAdapter extends RecyclerView.Adapter<PreviousReqRecycleAdapter.PreviousReqViewHolder> {

    private List<PreviousRequest> previousRequests;
    private Context mContext;

    public PreviousReqRecycleAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PreviousReqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PreviousReqListItemBinding mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.previous_req_list_item, parent, false);

        return new PreviousReqViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull PreviousReqViewHolder holder, int position) {
        PreviousRequest request = previousRequests.get(position);
        holder.mBinding.setPreviousReq(request);
    }

    @Override
    public int getItemCount() {
        if (previousRequests == null || previousRequests.isEmpty()) return 0;
        return previousRequests.size();
    }


    public void setPreviousRequests(List<PreviousRequest> previousRequests) {
        this.previousRequests = previousRequests;
        notifyDataSetChanged();
    }


    public class PreviousReqViewHolder extends RecyclerView.ViewHolder {

        PreviousReqListItemBinding mBinding;

        public PreviousReqViewHolder(@NonNull View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
            mBinding.deletePreRequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeItem(getAdapterPosition());
                }
            });
        }
    }

    private void removeItem(int position) {
        if (previousRequests != null && !previousRequests.isEmpty()) {
            previousRequests.remove(position);
            notifyItemRemoved(position);
        }
    }
}
