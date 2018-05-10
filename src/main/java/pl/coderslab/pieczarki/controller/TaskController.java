package pl.coderslab.pieczarki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.pieczarki.model.Employee;
import pl.coderslab.pieczarki.model.MushroomHall;
import pl.coderslab.pieczarki.model.Task;
import pl.coderslab.pieczarki.repository.EmployeeRepository;
import pl.coderslab.pieczarki.repository.MushroomHallRepository;
import pl.coderslab.pieczarki.repository.TaskRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    MushroomHallRepository mushroomHallRepository;

    @ModelAttribute("employees")
    public List<Employee> employees (){
        List<Employee> employees = employeeRepository.findAll();
        employees.sort(Comparator.comparing(Employee::getName).reversed());
        return employees;
    }

    @ModelAttribute("mushroomHalls")
    public List<MushroomHall> mushroomHalls(){
        return mushroomHallRepository.findAll();
    }

    @ModelAttribute("tasks")
    public List<String> tasks(){
        List<String> tasks =  new ArrayList<>();
        tasks.add("Preparing cultivation");
        tasks.add("Caring for cultivation ");
        tasks.add("Picking mushrooms");
        tasks.add("Cleaning after cultivation");
        tasks.add("Other");

        return tasks;
    }

    @GetMapping
    public String tasks(Model model){

        List<Task> list = taskRepository.findAll();
        model.addAttribute("list", list);

        return "listTask";
    }

    @GetMapping("/add")
    public String addTask(Model model){
        model.addAttribute("task", new Task());
        return "/form/addTask";
    }

    @PostMapping("/add")
    public String addTask(@Valid Task task, BindingResult result){
        if (result.hasErrors()){
            return "form/addTask";
        } else {
            taskRepository.save(task);
            return "redirect:/task";
        }
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model){

        Task task = taskRepository.getOne(id);
        model.addAttribute("task", task);

        return "form/editTask";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@Valid Task task, BindingResult result){
        if(result.hasErrors()){
            return "form/editTask";
        } else {
            taskRepository.save(task);
            return "redirect:/task";
        }

    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id, Model model){

        return "deleteTask";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){

        Task task = taskRepository.getOne(id);
        if(task==null){
            System.out.println("There are any task to delete");
        }  else{
            taskRepository.delete(task);
        }
        return "redirect:/task";
    }




}
