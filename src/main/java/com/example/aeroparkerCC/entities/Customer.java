package com.example.aeroparkerCC.entities;

import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Customer {
    private int id;
    private Date registered;
    private String email_address;
    private String title;
    private String first_name;
    private String last_name;
    private String address_line_1;
    private String address_line_2;
    private String city;
    private String postcode;
    private String phone_number;

    public int getCustomerID() {
        return id;
    }

    public void setCustomerID(int id) {
        this.id = id;
    }

    public Date getRegistered() {
        return registered;
    }

    public String getRegisteredAsString(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sf.format(registered);
        return dateString;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress_line_1() {
        return address_line_1;
    }

    public void setAddress_line_1(String address_line_1) {
        this.address_line_1 = address_line_1;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;

        if (id != customer.id) return false;
        if (!getRegistered().equals(customer.getRegistered())) return false;
        if (!getEmail_address().equals(customer.getEmail_address())) return false;
        if (!getTitle().equals(customer.getTitle())) return false;
        if (!getFirst_name().equals(customer.getFirst_name())) return false;
        if (!getLast_name().equals(customer.getLast_name())) return false;
        if (!getAddress_line_1().equals(customer.getAddress_line_1())) return false;
        if (getAddress_line_2() != null ? !getAddress_line_2().equals(customer.getAddress_line_2()) : customer.getAddress_line_2() != null)
            return false;
        if (getCity() != null ? !getCity().equals(customer.getCity()) : customer.getCity() != null) return false;
        if (!getPostcode().equals(customer.getPostcode())) return false;
        return getPhone_number().equals(customer.getPhone_number());
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + getRegistered().hashCode();
        result = 31 * result + getEmail_address().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getFirst_name().hashCode();
        result = 31 * result + getLast_name().hashCode();
        result = 31 * result + getAddress_line_1().hashCode();
        result = 31 * result + (getAddress_line_2() != null ? getAddress_line_2().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + getPostcode().hashCode();
        result = 31 * result + getPhone_number().hashCode();
        return result;
    }
}
