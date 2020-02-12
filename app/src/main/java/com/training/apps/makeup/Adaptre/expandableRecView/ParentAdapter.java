package com.training.apps.makeup.Adaptre.expandableRecView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.training.apps.makeup.R;
import com.training.apps.makeup.model.CartItem;
import com.training.apps.makeup.model.MyService;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {


    private Context mContext;
    private List<MyService> myServices;
    private CartItem cartItem;

    public ParentAdapter(Context context, List<MyService> myServices, CartItem cartItem) {
        this.mContext = context;
        this.myServices = myServices;
        this.cartItem = cartItem;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.expandable_list_parent_item, parent, false);
        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        MyService myService = myServices.get(position);
        holder.parentText.setText(myService.getServiceName());

        holder.childRec.setAdapter(new ChildRecAdapter(mContext, myService.getChildServices(), cartItem));
        holder.childRec.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        holder.childRec.setHasFixedSize(true);
    }

    @Override
    public int getItemCount() {
        if (myServices == null || myServices.size() == 0) return 0;
        return myServices.size();
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder {
        TextView parentText;
        RecyclerView childRec;
        ImageView arrowImage;
        ExpandableLayout expandableLayout;
        ConstraintLayout parentLayout;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
            parentText = itemView.findViewById(R.id.parent_title);
            childRec = itemView.findViewById(R.id.child_rec_view);
            arrowImage = itemView.findViewById(R.id.arrow_img);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            parentLayout = itemView.findViewById(R.id.parent_layout);

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    expandOrCollapse();
                }
            });
        }

        private void expandOrCollapse() {
            if (expandableLayout.isExpanded()) {
                arrowImage.setImageResource(R.drawable.ic_purple_arrow);
                expandableLayout.collapse(true);
            } else {
                arrowImage.setImageResource(R.drawable.ic_purple_arrow_up);
                expandableLayout.expand(true);
            }
        }
    }
}
