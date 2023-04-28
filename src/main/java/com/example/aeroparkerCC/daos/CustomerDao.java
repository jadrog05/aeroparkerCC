package com.example.aeroparkerCC.daos;

import com.example.aeroparkerCC.entities.Customer;

import java.util.List;

public interface CustomerDao {

    Customer getCustomerByID(int id);

    List<Customer> getAllCustomers();

    Customer addCustomer(Customer customer);

    Customer getCustomerByEmail(String email);
}
