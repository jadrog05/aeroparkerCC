package com.example.aeroparkerCC.service;

import com.example.aeroparkerCC.daos.CustomerDaoDB;
import com.example.aeroparkerCC.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerService {
    @Autowired
    CustomerDaoDB customerDao;

    private Date getTimestamp(){
        Date d = new Date();
        return d;
    }

    public Customer addCustomer(Customer c){
        c.setRegistered(getTimestamp());
        String lowerCaseEmail = c.getEmail_address().toLowerCase(); // ensures all email address are lowercase when added to db
        c.setEmail_address(lowerCaseEmail);
        return customerDao.addCustomer(c);
    }

    public boolean emailExists(String email){
        email = email.toLowerCase(); //compared as all lowercase to ensure uniqueness
        if (customerDao.getCustomerByEmail(email) == null){
            return false;
        } else {
            return true;
        }
    }
}
