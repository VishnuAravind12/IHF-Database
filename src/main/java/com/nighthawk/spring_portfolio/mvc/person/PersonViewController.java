package com.nighthawk.spring_portfolio.mvc.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

// Import necessary Spring and Java classes

// This class is a controller for handling Person-related operations in a Spring MVC application.
@Controller
@RequestMapping("/mvc/person")
public class PersonViewController {
    // Autowired annotation automatically injects the PersonDetailsService bean into this class.
    @Autowired
    private PersonDetailsService repository;

    // Handler method for GET requests to "/mvc/person/read" endpoint
    @GetMapping("/read")
    public String person(Model model) {
        // Retrieve a list of all persons from the repository
        List<Person> list = repository.listAll();
        // Add the list of persons to the model attribute
        model.addAttribute("list", list);
        // Return the name of the Thymeleaf template to render
        return "person/read";
    }

    // Handler method for GET requests to "/mvc/person/create" endpoint
    @GetMapping("/create")
    public String personAdd(Person person) {
        // Return the name of the Thymeleaf template for creating a new person
        return "person/create";
    }

    // Handler method for POST requests to "/mvc/person/create" endpoint
    @PostMapping("/create")
    public String personSave(@Valid Person person, BindingResult bindingResult) {
        // Validate the Person object using JSR-380 annotations
        if (bindingResult.hasErrors()) {
            // If there are validation errors, return back to the create form
            return "person/create";
        }
        // Save the person object to the repository
        repository.save(person);
        // Add the role "ROLE_STUDENT" to the person
        repository.addRoleToPerson(person.getEmail(), "ROLE_STUDENT");
        // Redirect to the read endpoint to display the updated list of persons
        return "redirect:/mvc/person/read";
    }

    // Handler method for GET requests to "/mvc/person/update/{id}" endpoint
    @GetMapping("/update/{id}")
    public String personUpdate(@PathVariable("id") int id, Model model) {
        // Retrieve the person with the specified ID from the repository
        model.addAttribute("person", repository.get(id));
        // Return the name of the Thymeleaf template for updating a person
        return "person/update";
    }

    // Handler method for POST requests to "/mvc/person/update" endpoint
    @PostMapping("/update")
    public String personUpdateSave(@Valid Person person, BindingResult bindingResult) {
        // Validate the updated Person object using JSR-380 annotations
        if (bindingResult.hasErrors()) {
            // If there are validation errors, return back to the update form
            return "person/update";
        }
        // Save the updated person object to the repository
        repository.save(person);
        // Add the role "ROLE_STUDENT" to the updated person
        repository.addRoleToPerson(person.getEmail(), "ROLE_STUDENT");
        // Redirect to the read endpoint to display the updated list of persons
        return "redirect:/mvc/person/read";
    }

    // Handler method for GET requests to "/mvc/person/delete/{id}" endpoint
    @GetMapping("/delete/{id}")
    public String personDelete(@PathVariable("id") long id) {
        // Delete the person with the specified ID from the repository
        repository.delete(id);
        // Redirect to the read endpoint to display the updated list of persons
        return "redirect:/mvc/person/read";
    }

    // Handler method for GET requests to "/mvc/person/search" endpoint
    @GetMapping("/search")
    public String person() {
        // Return the name of the Thymeleaf template for searching persons
        return "person/search";
    }

}
