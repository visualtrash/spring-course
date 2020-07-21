package com.nik.springdemo.controller;

import com.nik.springdemo.dao.CustomerDAO;
import com.nik.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //inject dao
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model) {

        //get customers from dao
        List<Customer> customers = customerDAO.getCustomers();

        //add customers to the model
        model.addAttribute("customers", customers);

        return "list-customers";
    }
}
