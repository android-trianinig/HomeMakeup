package com.training.apps.makeup.Adaptre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.training.apps.makeup.R;
import com.training.apps.makeup.databinding.NotificationListItemBinding;
import com.training.apps.makeup.model.MyNotification;

import java.util.List;

public class NotificationRecycleAdapter extends RecyclerView.Adapter<NotificationRecycleAdapter.NotificationViewHolder> {

    private List<MyNotification> myNotificationList;
    private Context mContext;

    public NotificationRecycleAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NotificationListItemBinding mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.notification_list_item, parent, false);

        return new NotificationViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        MyNotification notification = myNotificationList.get(position);
        holder.mBinding.setMyNotification(notification);
    }

    @Override
    public int getItemCount() {
        return myNotificationList.size();
    }


    public void setMyNotificationList(List<MyNotification> myNotificationList) {
        this.myNotificationList = myNotificationList;
        notifyDataSetChanged();
    }


    public class NotificationViewHolder extends RecyclerView.ViewHolder {

        NotificationListItemBinding mBinding;

        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
            mBinding.deleteNotification.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeNotification(getAdapterPosition());
                }
            });
        }
    }

    private void removeNotification(int position) {
        if (!myNotificationList.isEmpty()) {
            myNotificationList.remove(position);
            notifyItemRemoved(position);
        }
    }
}
