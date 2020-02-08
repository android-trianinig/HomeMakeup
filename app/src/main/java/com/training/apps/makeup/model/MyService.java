package com.training.apps.makeup.model;


import java.util.Objects;

//test only
public class MyService {
    String serviceName;

    public MyService(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyService service = (MyService) o;
        return serviceName.equals( service.serviceName);
    }

    @Override
    public int hashCode() {
        return serviceName.hashCode();
    }
}
