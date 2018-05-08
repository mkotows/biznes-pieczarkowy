package pl.coderslab.pieczarki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.pieczarki.model.Employee;
import pl.coderslab.pieczarki.repository.EmployeeRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String employees(Model model){

        List<Employee> list = employeeRepository.findAll();
        model.addAttribute("list", list);

        return "list_employee";
    }


    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "/form/addEmployee";
    }

    @PostMapping("/add")
    public String addEmployee(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            return "form/addEmployee";
        } else {
            employeeRepository.save(employee);
            return "redirect:/employee";
        }
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model){

        Employee employee = employeeRepository.getOne(id);
        model.addAttribute("employee", employee);

        return "form/editEmployee";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@Valid Employee employee, BindingResult result){
        if(result.hasErrors()){
            return "form/editEmployee";
        } else {
            employeeRepository.save(employee);
            return "redirect:/employee";
        }

    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, Model model){

        return "deleteEmployee";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){

        Employee employee = employeeRepository.getOne(id);
        if(employee==null){
            System.out.println("There are any employee to delete");
        }  else{
            employeeRepository.delete(employee);
        }
        return "redirect:/employee";
    }




}
