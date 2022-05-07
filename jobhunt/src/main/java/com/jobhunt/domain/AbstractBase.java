package com.jobhunt.domain;

public abstract class AbstractBase extends IDBase {

    private String name;
    private String address;
    private String email;

    public AbstractBase() {
    }

    public AbstractBase(String id,String name, String address, String email) {
        super(id);
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\''
                ;
    }
}
