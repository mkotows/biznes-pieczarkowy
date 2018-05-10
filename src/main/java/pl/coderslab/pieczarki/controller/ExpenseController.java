package pl.coderslab.pieczarki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.pieczarki.model.Expense;
import pl.coderslab.pieczarki.model.MushroomHall;
import pl.coderslab.pieczarki.repository.ExpenseRepository;
import pl.coderslab.pieczarki.repository.MushroomHallRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    MushroomHallRepository mushroomHallRepository;
    @Autowired
    ExpenseRepository expenseRepository;

    @ModelAttribute("mushroomHalls")
    public List<MushroomHall> getMushroomList(){
        return mushroomHallRepository.findAll();
    }

    @ModelAttribute("expenses")
    public List<String> getExpenseName(){
        List<String> expenses = new ArrayList<>();
        expenses.add("Electrity");
        expenses.add("Water");
        expenses.add("Gas");
        expenses.add("Subsoil");
        expenses.add("Torf");
        expenses.add("Others");

        return expenses;
    }

    @GetMapping
    public String expenses(Model model){

        List<Expense> list = expenseRepository.findAll();
        model.addAttribute("list", list);

        return "listExpense";
    }

    @GetMapping("/add")
    public String addExpense(Model model){
        model.addAttribute("expense", new Expense());
        return "/form/addExpense";
    }


    @PostMapping("/add")
    public String addExpense(@Valid Expense expense, BindingResult result){
        if (result.hasErrors()){
            return "form/addExpense";
        } else {
            expenseRepository.save(expense);
            return "redirect:/expense";
        }
    }

    @GetMapping("/edit/{id}")
    public String editExpense(@PathVariable Long id, Model model){

        Expense expense = expenseRepository.getOne(id);
        model.addAttribute("expense", expense);

        return "form/editExpense";
    }

    @PostMapping("/edit/{id}")
    public String editExpense(@Valid Expense expense, BindingResult result){
        if(result.hasErrors()){
            return "form/editExpense";
        } else {
            expenseRepository.save(expense);
            return "redirect:/expense";
        }

    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id, Model model){

        return "deleteExpense";
    }

    @PostMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id){

        Expense expense = expenseRepository.getOne(id);
        if(expense==null){
            System.out.println("There are any expense to delete");
        }  else{
            expenseRepository.delete(expense);
        }
        return "redirect:/expense";
    }




}
