package com.example.aeroparkerCC.daos;

import com.example.aeroparkerCC.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDaoDB implements CustomerDao{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Customer getCustomerByID(int id) {
        try{
            String SELECT_CUSTOMER_BY_ID = "SELECT * FROM Customers WHERE id = ?;";
            Customer customer = jdbc.queryForObject(SELECT_CUSTOMER_BY_ID, new CustomerMapper(),id);
            return customer;
        } catch (DataAccessException e){
            return null;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        try{
            String SELECT_ALL_CUSTOMERS = "SELECT * FROM Customers;";
            List<Customer> customers = jdbc.query(SELECT_ALL_CUSTOMERS, new CustomerMapper());
            return customers;
        } catch (DataAccessException e){
            return null;
        }
    }

    @Override
    public Customer addCustomer(Customer customer) {
        try{
            String INSERT_CUSTOMER = "INSERT INTO Customers(registered, email_address, title, first_name, last_name, " +
                    "address_line_1, address_line_2, city, postcode, phone_number) VALUES(?,?,?,?,?,?,?,?,?,?);";
            jdbc.update(INSERT_CUSTOMER,
                    customer.getRegisteredAsString(),
                    customer.getEmail_address(),
                    customer.getTitle(),
                    customer.getFirst_name(),
                    customer.getLast_name(),
                    customer.getAddress_line_1(),
                    customer.getAddress_line_2(),
                    customer.getCity(),
                    customer.getPostcode(),
                    customer.getPhone_number());
            int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
            customer.setCustomerID(newID);
            return customer;
        } catch (DataAccessException e){
            return null;
        }
    }

    @Override
    public Customer getCustomerByEmail(String email){
        try{
            String SELECT_CUSTOMER_BY_EMAIL = "SELECT * FROM Customers WHERE email_address = ?;";
            Customer c = jdbc.queryForObject(SELECT_CUSTOMER_BY_EMAIL, new CustomerMapper(), email);
            return c;
        } catch (DataAccessException e){
            return null;
        }
    }

    public static final class CustomerMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int index) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerID(rs.getInt("id"));
            customer.setEmail_address(rs.getString("email_address"));
            customer.setRegistered(rs.getDate("registered"));
            customer.setTitle(rs.getString("title"));
            customer.setFirst_name(rs.getNString("first_name"));
            customer.setLast_name(rs.getString("last_name"));
            customer.setAddress_line_1(rs.getString("address_line_1"));
            customer.setAddress_line_2(rs.getString("address_line_2"));
            customer.setCity(rs.getString("city"));
            customer.setPostcode(rs.getString("postcode"));
            customer.setPhone_number(rs.getString("phone_number"));
            return customer;
        }
    }
}
