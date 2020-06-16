package com.nik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {

        //создание объекта
        Student student = new Student();

        //добавление экз студента в модель
        model.addAttribute("student", student);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {

        System.out.printf("student: " + student.getFirstName()
                + " " + student.getLastName());

        return "student-confirmation";
    }
}
