package com.nik;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //show initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //process HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }
}
