package com.nik.springdemo.dao;

import com.nik.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

}
