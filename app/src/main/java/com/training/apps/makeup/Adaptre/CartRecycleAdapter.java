package com.training.apps.makeup.Adaptre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.training.apps.makeup.R;
import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.CartListItemBinding;
import com.training.apps.makeup.model.ChildService;

import java.util.ArrayList;
import java.util.List;

public class CartRecycleAdapter extends RecyclerView.Adapter<CartRecycleAdapter.CartViewHolder> {

    private List<ChildService> cartItems;
    private Context mContext;
    private MutableLiveData<List<ChildService>> listMutableLiveData;

    public CartRecycleAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartListItemBinding mBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.cart_list_item, parent, false);

        return new CartViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        ChildService childService = cartItems.get(position);
        holder.mBinding.setChildService(childService);
    }

    @Override
    public int getItemCount() {
        if (cartItems == null || cartItems.size() == 0) return 0;
        return cartItems.size();
    }


    public void setCartItems(MutableLiveData<List<ChildService>> listMutableLiveData) {

        List<ChildService> childServices = listMutableLiveData.getValue();

        if (childServices != null) {

            this.cartItems = childServices;
        } else {

            this.cartItems = new ArrayList<>();
        }
        notifyDataSetChanged();
    }


    public class CartViewHolder extends RecyclerView.ViewHolder {

        CartListItemBinding mBinding;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
            mBinding.deleteChild.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeCartItem(getAdapterPosition());
                }
            });
        }
    }

    private void removeCartItem(int position) {
        if (!cartItems.isEmpty()) {
            cartItems.remove(position);
            HomeMakeupRepo.cartItems.setValue(cartItems);
            notifyItemRemoved(position);
        }
    }
}
