package com.training.apps.makeup.Adaptre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.training.apps.makeup.R;
import com.training.apps.makeup.model.ChildService;
import com.training.apps.makeup.model.MyService;

import java.util.HashMap;
import java.util.List;

public class ExpandableServicesListAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<MyService> myServiceList;
    private HashMap<MyService, List<ChildService>> serviceChild;

    public ExpandableServicesListAdapter(Context mContext, List<MyService> myServiceList, HashMap<MyService, List<ChildService>> serviceChild) {
        this.mContext = mContext;
        this.myServiceList = myServiceList;
        this.serviceChild = serviceChild;
    }

    @Override
    public int getGroupCount() {
        return myServiceList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return serviceChild.get(myServiceList.get(i)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return myServiceList.get(groupPosition).getServiceName();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return serviceChild.get(myServiceList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String header = ((String) getGroup(groupPosition));
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandable_list_parent_item, null);

            TextView serviceTitle = convertView.findViewById(R.id.parent_title);
            serviceTitle.setText(header);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ChildService childService = (ChildService) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.expandable_list_radio_group, null);

            View childView = inflater.inflate(R.layout.expandable_list_child_layout, null);

            RadioButton radioButton = childView.findViewById(R.id.service_title_radio);
            radioButton.setText(childService.getChildServiceTitle());

            TextView textView = childView.findViewById(R.id.service_duration);
            textView.setText(childService.getChildServiceDuration());

            textView = childView.findViewById(R.id.service_cost);
            textView.setText(String.valueOf(childService.getChildServiceCost()));


            textView = childView.findViewById(R.id.service_currency);
            textView.setText(childService.getChildServiceCurrency());


            RadioGroup radioGroup = convertView.findViewById(R.id.child_group);

            radioGroup.addView(childView);

        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
