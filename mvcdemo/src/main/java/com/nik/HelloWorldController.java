package com.nik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
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

    //new controller method to read form data
    //and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        //read request parameter from HTML form
        String name = request.getParameter("studentName");

        //convert the data to all caps
        name = name.toUpperCase();

        //create the message
        String result = "Yo! " + name;

        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name,
                                          Model model) {

        //convert the data to all caps
        name = name.toUpperCase();

        //create the message
        String result = "Hey my friend from v3! " + name;

        //add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
