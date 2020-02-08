package com.training.apps.makeup.databinding;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

import java.util.List;

public class SpinnerViewModel {

    @BindingAdapter("entries")
    public static void setSpinnerEntries(Spinner spinner, List<String> entries) {
        if (entries == null || entries.size() == 0) {
            return;
        }
        if (spinner.getAdapter() == null) {
            ArrayAdapter<String> adapter =
                    new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_spinner_item, entries);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }
        spinner.setSelection(0);
    }

    @BindingAdapter(value = {"selectedValue", "selectedValueAttrChanged"}, requireAll = false)
    public static void bindSpinnerData(Spinner spinner, String newSelectedValue, final InverseBindingListener newTextAttrChanged) {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                newTextAttrChanged.onChange();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        if (newSelectedValue != null) {
            int pos = ((ArrayAdapter<String>) spinner.getAdapter()).getPosition(newSelectedValue);
            spinner.setSelection(pos, true);
        }
    }
    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    public static String captureSelectedValue(AppCompatSpinner pAppCompatSpinner) {
        return (String) pAppCompatSpinner.getSelectedItem();
    }

}
