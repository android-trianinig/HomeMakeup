package com.training.apps.makeup.ui.main.clientProvider;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.training.apps.makeup.Adaptre.expandableRecView.ParentAdapter;
import com.training.apps.makeup.R;
import com.training.apps.makeup.data.HomeMakeupRepo;
import com.training.apps.makeup.databinding.FragmentProviderServicesBinding;
import com.training.apps.makeup.model.CartItem;
import com.training.apps.makeup.model.MyService;

import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_ProviderServices extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    public FragmentProviderServicesBinding mBinding;
    private List<MyService> myServiceList;
    public CartItem cartItem;
    private ConstraintLayout pickDate, pickTime;
    private Button addToCart;
    private TextView dataText, timeText;
    private boolean isDateSelected = false;
    private boolean isTimeSelected = false;


    public Fragment_ProviderServices() {

    }

    public Fragment_ProviderServices(List<MyService> myServices) {
        this.myServiceList = myServices;
    }

    public static Fragment_ProviderServices getInstance() {
        return new Fragment_ProviderServices();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentProviderServicesBinding.inflate(inflater);

        cartItem = new CartItem();
        mBinding.setCartItem(cartItem);
        ParentAdapter servicesAdapter = new ParentAdapter(getContext(), myServiceList, cartItem);
        mBinding.servicesListRec.setAdapter(servicesAdapter);
        mBinding.servicesListRec.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mBinding.servicesListRec.setHasFixedSize(true);

        mBinding.confirmOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cartItem.getCartItem().size() == 0) {
                    Toast.makeText(getContext(), R.string.cart_is_empty, Toast.LENGTH_SHORT).show();

                } else {
                    openDialog();
                }
            }
        });

        return mBinding.getRoot();
    }

    private void openDialog() {
        Dialog dialog = new Dialog(getActivity(), android.R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_date_time_layout);
        dialog.setCanceledOnTouchOutside(true);
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        pickDate = dialog.findViewById(R.id.date_picker);
        pickTime = dialog.findViewById(R.id.time_picker);
        addToCart = dialog.findViewById(R.id.add_to_cart_btn);
        dataText = dialog.findViewById(R.id.select_date_title);
        timeText = dialog.findViewById(R.id.select_time_title);

        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isDateSelected) {
                    Toast.makeText(getContext(), getString(R.string.please_selecte_date), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!isTimeSelected) {
                    Toast.makeText(getContext(), getString(R.string.please_selecte_time), Toast.LENGTH_SHORT).show();
                    return;
                }
                HomeMakeupRepo.cartItems.add(cartItem);
                Toast.makeText(getContext(), "Added to Cart ", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                this,
                Calendar.getInstance().get(Calendar.HOUR),
                Calendar.getInstance().get(Calendar.MINUTE),
                DateFormat.is24HourFormat(getActivity())
        );
        timePickerDialog.show();
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "-" + month + "-" + year;

        dataText.setText(date);
        cartItem.setDay(dayOfMonth);
        cartItem.setMonth(month);
        cartItem.setYear(year);
        isDateSelected = true;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String time = hourOfDay + ":" + minute;
        timeText.setText(time);
        cartItem.setHour(hourOfDay);
        cartItem.setMinute(minute);
        isTimeSelected = true;
    }
}
