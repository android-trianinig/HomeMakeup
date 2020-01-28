package com.training.apps.makeup.Adaptre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.training.apps.makeup.R;
import com.training.apps.makeup.model.MyProvider;
import com.training.apps.makeup.model.MyService;

import java.util.List;

public class ProviderRecycleAdapter extends RecyclerView.Adapter<ProviderRecycleAdapter.ServiceViewHolder> {

    private List<MyProvider> myServices;
    private Context mContext;

    public ProviderRecycleAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.service_titles_list_item_layout, parent, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        MyService service = myServices.get(position);
        holder.serviceNameTxtView.setText(service.getServiceName());
        if (position == 0) {
            holder.serviceNameTxtView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
        }
    }

    @Override
    public int getItemCount() {
        if (myServices != null && myServices.size() > 0) return myServices.size();
        return 0;
    }

    public void setMyServices(List<MyService> myServices) {
        this.myServices = myServices;
        notifyDataSetChanged();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView serviceNameTxtView;

        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceNameTxtView = itemView.findViewById(R.id.txt_service_name);
            serviceNameTxtView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, serviceNameTxtView.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
