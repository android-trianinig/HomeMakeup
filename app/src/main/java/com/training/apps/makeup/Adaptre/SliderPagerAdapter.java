package com.training.apps.makeup.Adaptre;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.imageview.ExperimentalImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.CornerFamily;
import com.training.apps.makeup.R;
import com.training.apps.makeup.model.Offer;

import java.util.List;

public class SliderPagerAdapter extends PagerAdapter {
    private List<Offer> offers;
    private Context mContext;


    public SliderPagerAdapter(List<Offer> offers, Context context) {
        this.mContext = context;
        this.offers = offers;

    }

    @ExperimentalImageView
    private ShapeableImageView getShapeableImageView(ViewGroup container, Context context, int resId) {

        ShapeableImageView imageView = new ShapeableImageView(context);

        imageView.setShapeAppearanceModel(imageView.getShapeAppearanceModel()
                .toBuilder()
                .setTopRightCorner(CornerFamily.ROUNDED,70)
                .setTopLeftCorner(CornerFamily.ROUNDED, 70)
                .setBottomLeftCorner(CornerFamily.ROUNDED, 70)
                .build());

        imageView.setImageResource(resId);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public int getCount() {
        return offers.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    @ExperimentalImageView
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int resId = offers.get(position).getOfferImage();
        return getShapeableImageView(container, mContext,resId);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
