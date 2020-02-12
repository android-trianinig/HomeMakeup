package com.training.apps.makeup.model;


import java.util.List;

//test only
public class MyService {
    private String serviceName;
    private List<ChildService> childServices;
    private boolean isExpanded;


    public MyService(String serviceName, List<ChildService> childServices) {
        this.serviceName = serviceName;
        this.childServices = childServices;
    }

    public String getServiceName() {
        return serviceName;
    }

    public List<ChildService> getChildServices() {
        return childServices;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
