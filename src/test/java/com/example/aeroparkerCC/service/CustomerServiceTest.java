package com.example.aeroparkerCC.service;

import com.example.aeroparkerCC.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {
    @Autowired
    CustomerService customerService;

    @Test
    void testAddAndRemoveCustomer() {
        Customer cTest = new Customer();
        cTest.setEmail_address("testService@caseemail.com");
        cTest.setTitle("Mr");
        cTest.setFirst_name("TestFirst");
        cTest.setLast_name("TestLast");
        cTest.setRegistered(new Date());
        cTest.setAddress_line_1("TestLine1");
        cTest.setAddress_line_2("TestLine2");
        cTest.setCity("TestCity");
        cTest.setPostcode("TestCode");
        cTest.setPhone_number("0123456789");



        Customer fromService = customerService.addCustomer(cTest);
        Customer fromServiceDuplicate = customerService.addCustomer(cTest);

        assertNotNull(fromService);
        assertNull(fromServiceDuplicate);
        assertNotNull(fromService.getCustomerID());
        assertNotNull(fromService.getRegistered());

        boolean removedTest = customerService.deleteCustomerByEmail(cTest.getEmail_address());

        assertTrue(removedTest);
    }

    @Test
    void emailExists() {
        Customer cTest = new Customer();
        cTest.setEmail_address("testService@caseemail.com");
        cTest.setTitle("Mr");
        cTest.setFirst_name("TestFirst");
        cTest.setLast_name("TestLast");
        cTest.setRegistered(new Date());
        cTest.setAddress_line_1("TestLine1");
        cTest.setAddress_line_2("TestLine2");
        cTest.setCity("TestCity");
        cTest.setPostcode("TestCode");
        cTest.setPhone_number("0123456789");

        assertFalse(customerService.emailExists(cTest.getEmail_address())); //email should not exist as hasn't been added to db yet

        Customer fromService = customerService.addCustomer(cTest);

        assertTrue(customerService.emailExists(cTest.getEmail_address())); //now email should exist
        assertTrue(customerService.emailExists(cTest.getEmail_address().toUpperCase())); //should also exist as it is not case-sensitive.

        customerService.deleteCustomerByEmail(cTest.getEmail_address());


    }
}