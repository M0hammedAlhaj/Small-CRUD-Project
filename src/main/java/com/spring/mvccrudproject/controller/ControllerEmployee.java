/**
 * Controller class for managing employees in the Employee Directory.
 * Provides endpoints for CRUD operations such as listing, adding, updating, and deleting employees.
 */
package com.spring.mvccrudproject.controller;

import com.spring.mvccrudproject.entity.Employee;
import com.spring.mvccrudproject.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing employee-related operations.
 */
@Controller
@RequestMapping("/employeeDirectory")
public class ControllerEmployee {

    /**
     * Service for managing employee operations.
     */
    private EmployeeService employeeService;

    /**
     * Constructor for injecting the EmployeeService.
     *
     * @param employeeService the employee service
     */
    @Autowired
    public ControllerEmployee(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Displays the employee directory.
     *
     * @param model the model to hold employee data
     * @return the employee directory view
     */
    @GetMapping("/")
    public String employeeDirectory(Model model) {
        model.addAttribute("employeeList", employeeService.getAllEmployee());
        return "employeeDirectory";
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param employeeId the ID of the employee to delete
     * @return redirect to the employee directory
     */
    @GetMapping("/delete")
    public String employeeDelete(@RequestParam(name = "employeeId") Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/employeeDirectory/";
    }

    /**
     * Displays the add employee form.
     *
     * @param model the model to hold the new employee object
     * @return the add employee view
     */
    @GetMapping("/add")
    public String employeeAdd(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeAdd";
    }

    /**
     * Handles submission of the add employee form.
     *
     * @param employee      the employee object to add
     * @param bindingResult the binding result for validation
     * @return redirect to the employee directory or the add employee view if there are errors
     */
    @PostMapping("/submitAdd")
    public String submitAdd(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employeeAdd";
        }
        employeeService.addEmployee(employee);
        return "redirect:/employeeDirectory/";
    }

    /**
     * Displays the update employee form.
     *
     * @param employeeId the ID of the employee to update
     * @param model      the model to hold the employee data
     * @return the update employee view
     */
    @PostMapping("/update")
    public String employeeUpdate(@RequestParam(name = "employeeId") Integer employeeId, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(employeeId));
        return "employeeUpdate";
    }

    /**
     * Handles submission of the update employee form.
     *
     * @param employee      the updated employee object
     * @param bindingResult the binding result for validation
     * @return redirect to the employee directory or the update employee view if there are errors
     */
    @PostMapping("/submitUpdate")
    public String submitUpdate(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employeeUpdate";
        }
        employeeService.updateEmployee(employee);
        return "redirect:/employeeDirectory/";
    }
}
