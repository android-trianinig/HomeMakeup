package com.training.apps.makeup.Adaptre.expandableRecView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.training.apps.makeup.R;
import com.training.apps.makeup.model.SelectedService;
import com.training.apps.makeup.model.ChildService;

import java.util.List;

public class ChildRecAdapter extends RecyclerView.Adapter<ChildRecAdapter.ChildViewHolder> {

    private List<ChildService> childServices;
    private Context mContext;
    private SelectedService selectedService;

    public ChildRecAdapter(Context context, List<ChildService> childServices, SelectedService selectedService) {
        this.childServices = childServices;
        this.mContext = context;
        this.selectedService = selectedService;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.expandable_list_child_layout, parent, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        ChildService childService = childServices.get(position);
        holder.childTitle.setText(childService.getChildServiceTitle());
        holder.childCost.setText(childService.getChildServiceCost() + "");
        holder.childDuration.setText(childService.getChildServiceDuration());
        holder.childCurrency.setText(childService.getChildServiceCurrency());
        holder.childTitle.post(new Runnable() {
            @Override
            public void run() {
                holder.childTitle.setChecked(childService.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.childServices == null || childServices.size() == 0) return 0;
        return childServices.size();
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {

        RadioButton childTitle;
        TextView childDuration;
        TextView childCost;
        TextView childCurrency;
        ConstraintLayout childLayout;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);

            childTitle = itemView.findViewById(R.id.child_title_radio);
            childCost = itemView.findViewById(R.id.child_cost);
            childDuration = itemView.findViewById(R.id.child_duration);
            childCurrency = itemView.findViewById(R.id.child_currency);
            childLayout = itemView.findViewById(R.id.child_layout);

            childLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setCheckedChild();
                }
            });

            childTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setCheckedChild();
                }
            });
        }

        private void setCheckedChild() {
            for (ChildService childService : childServices) {
                if (!childService.getChildServiceTitle().equals(childTitle.getText().toString())) {
                    childService.setChecked(false);
                } else {
                    childService.setChecked(true);

                    selectedService.addItem(childService.getParent(), childService);
                    System.out.println(selectedService.getSelectedServices().size());
                    for (ChildService ch : selectedService.getSelectedServices().values()
                    ) {
                        System.out.println(ch.getChildServiceTitle());
                    }
                }
            }
            notifyDataSetChanged();
        }
    }
}
