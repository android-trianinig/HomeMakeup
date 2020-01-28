package com.training.apps.makeup.Adaptre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ExperimentalImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;
import com.training.apps.makeup.R;
import com.training.apps.makeup.model.MyProvider;
import com.training.apps.makeup.ui.main.RoundedTopImageView;

import java.util.List;

public class ProviderRecycleAdapter extends RecyclerView.Adapter<ProviderRecycleAdapter.ProviderViewHolder> {

    private List<MyProvider> myProviders;
    private Context mContext;

    public ProviderRecycleAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    @ExperimentalImageView
    public ProviderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.service_provider_list_item_layout, parent, false);
        return new ProviderViewHolder(view);
    }

    @Override
    @ExperimentalImageView
    public void onBindViewHolder(@NonNull ProviderViewHolder holder, int position) {
        MyProvider provider = myProviders.get(position);

        holder.providerName.setText(provider.getProviderName());
        holder.providerRate.setRating((float)provider.getProviderRate()*5/10);
        holder.providerType.setText(provider.getProviderType());
        holder.providerCity.setText(provider.getProviderCity());
        holder.providerBanner.setImageResource(provider.getProviderImage());
    }

    @Override
    public int getItemCount() {
        if (myProviders != null && myProviders.size() > 0) return myProviders.size();
        return 0;
    }

    public void setMyProviders(List<MyProvider> myProviders) {
        this.myProviders = myProviders;
        notifyDataSetChanged();
    }

    public class ProviderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView providerName;
        TextView providerType;
        RatingBar providerRate;
        TextView providerCity;
        RoundedTopImageView providerBanner;

        @ExperimentalImageView
        public ProviderViewHolder(@NonNull View itemView) {
            super(itemView);
            providerName = itemView.findViewById(R.id.item_provider_name);
            providerType = itemView.findViewById(R.id.item_provider_type);
            providerRate = itemView.findViewById(R.id.item_provider_rate);
            providerCity = itemView.findViewById(R.id.item_provider_city);
            providerBanner =  itemView.findViewById(R.id.item_provider_provider_banner);

            providerBanner.setScaleType(ImageView.ScaleType.CENTER_CROP);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, providerName.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}