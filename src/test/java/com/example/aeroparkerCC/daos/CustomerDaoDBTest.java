package com.example.aeroparkerCC.daos;

import com.example.aeroparkerCC.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerDaoDBTest {
    @Autowired
    JdbcTemplate jdbc;
    @Autowired
    CustomerDaoDB customerDao;

    @Test
    void testAddGetRemoveCustomer() {
        Customer cTest = new Customer();
        cTest.setEmail_address("Test@caseemail.com");
        cTest.setTitle("Mr");
        cTest.setFirst_name("TestFirst");
        cTest.setLast_name("TestLast");
        cTest.setRegistered(new Date());
        cTest.setAddress_line_1("TestLine1");
        cTest.setAddress_line_2("TestLine2");
        cTest.setCity("TestCity");
        cTest.setPostcode("TestCode");
        cTest.setPhone_number("0123456789");

        cTest = customerDao.addCustomer(cTest);

        Customer fromDao = customerDao.getCustomerByEmail(cTest.getEmail_address());

        assertNotNull(cTest);
        assertNotNull(fromDao);
        assertEquals(cTest.getFirst_name(), fromDao.getFirst_name());

        boolean testDelete = customerDao.deleteCustomerByEmail(cTest.getEmail_address());

        assertTrue(testDelete);
        assertNull(customerDao.getCustomerByEmail(cTest.getEmail_address()));
    }
}