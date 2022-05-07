package com.jobhunt.domain;

public class IDBase {
    private String id;

    public IDBase() {
    }

    public IDBase(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return
                "id='" + id ;

    }
}
