package pl.coderslab.pieczarki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.pieczarki.model.Income;
import pl.coderslab.pieczarki.model.MushroomHall;
import pl.coderslab.pieczarki.repository.IncomeRepository;
import pl.coderslab.pieczarki.repository.MushroomHallRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/income")
public class IncomeController {

    @Autowired
    MushroomHallRepository mushroomHallRepository;
    @Autowired
    IncomeRepository incomeRepository;

    @ModelAttribute("mushroomNames")
    public List<String> getMushroomNames(){
        List<String> mushroomNames = new ArrayList<>();
        mushroomNames.add("Normalny");
        mushroomNames.add("Brązowy");
        mushroomNames.add("PortoBello");
        mushroomNames.add("Shitake");
        mushroomNames.add("Boczniak");
        mushroomNames.add("Inny");

        return mushroomNames;
    }
    
    @ModelAttribute("mushroomHalls")
    public List<MushroomHall> getMushroomList(){
        return mushroomHallRepository.findAll();
    }


    @GetMapping
    public String incomes(Model model){

        List<Income> list = incomeRepository.findAll();
        model.addAttribute("list", list);

        return "listIncome";
    }

    @GetMapping("/add")
    public String addIncome(Model model){
        model.addAttribute("income", new Income());
        return "/form/addIncome";
    }


    @PostMapping("/add")
    public String addIncome(@Valid Income income, BindingResult result){
        if (result.hasErrors()){
            return "form/addIncome";
        } else {
            incomeRepository.save(income);
            return "redirect:/income";
        }
    }

    @GetMapping("/edit/{id}")
    public String editIncome(@PathVariable Long id, Model model){

        Income income = incomeRepository.getOne(id);
        model.addAttribute("income", income);

        return "form/editIncome";
    }

    @PostMapping("/edit/{id}")
    public String editIncome(@Valid Income income, BindingResult result){
        if(result.hasErrors()){
            return "form/editIncome";
        } else {
            incomeRepository.save(income);
            return "redirect:/income";
        }

    }

    @GetMapping("/delete/{id}")
    public String deleteIncome(@PathVariable Long id, Model model){

        return "deleteIncome";
    }

    @PostMapping("/delete/{id}")
    public String deleteIncome(@PathVariable Long id){

        Income income = incomeRepository.getOne(id);
        if(income==null){
            System.out.println("There are any income to delete");
        }  else{
            incomeRepository.delete(income);
        }
        return "redirect:/income";
    }


}
