package pl.coderslab.pieczarki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.pieczarki.model.Expense;
import pl.coderslab.pieczarki.model.MushroomHall;
import pl.coderslab.pieczarki.model.Task;
import pl.coderslab.pieczarki.repository.ExpenseRepository;
import pl.coderslab.pieczarki.repository.MushroomHallRepository;
import pl.coderslab.pieczarki.repository.TaskRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/raport/expenses")
public class RaportExpensesController {

    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    MushroomHallRepository mushroomHallRepository;
    @Autowired
    TaskRepository taskRepository;

    @ModelAttribute("mushroomHalls")
    public List<MushroomHall> getMushroomHalls(){
        return mushroomHallRepository.findAll();
    }

    @GetMapping
    public String getRaports(){
        return "raport/listRaportExpenses";
    }

    @PostMapping("/one")
//    @ResponseBody
    public String reportForOneHall(Model model,
                                   @RequestParam String hallId,
                                   @RequestParam String start,
                                   @RequestParam String end
                                   ){


//        System.out.println(hallId);
        MushroomHall mushroomHall = mushroomHallRepository.getOne(Long.parseLong(hallId));

        Date start1 = Date.valueOf(start);
        Date end1 =  Date.valueOf(end);
        List<Expense> expenses = expenseRepository.findAllByMushroomHallAndDateBetween(mushroomHall,start1, end1);
        List<Task> tasks = taskRepository.findAllByMushroomHallAndDateBetween(mushroomHall,start1, end1);

        String resultText = getResultText(start, end, expenses, tasks);

        model.addAttribute("expenses",expenses);
        model.addAttribute("tasks",tasks);
        model.addAttribute("resultText",resultText);

        return "raport/listResultExpenses";
    }

    @PostMapping("/all")
    public String reportForAllHall(Model model,
                                   @RequestParam String start,
                                   @RequestParam String end ){

        Date start1 = Date.valueOf(start);
        Date end1 =  Date.valueOf(end);
//        System.out.println(start1);
//        System.out.println(end1);

        List<Expense> expenses = expenseRepository.findAllByDateBetween(start1,end1);
        List<Task> tasks = taskRepository.findAllByDateBetween(start1,end1);

        String resultText = getResultText(start, end, expenses, tasks);

        model.addAttribute("expenses",expenses);
        model.addAttribute("tasks",tasks);
        model.addAttribute("resultText",resultText);

        return "raport/listResultExpenses";
    }


    private String getResultText(String start, String end, List<Expense> expenses, List<Task> tasks) {
        BigDecimal sumTask = new BigDecimal("0");
        BigDecimal sumExpense = new BigDecimal("0");

        for (Task task: tasks){
            sumTask = sumTask.add(task.getCost());
        }
        for (Expense expense: expenses){
            sumExpense = sumExpense.add(expense.getCost());
        }

        BigDecimal totalCosts = sumExpense.add(sumTask);

        return "Raport dla okresu od " + start + " do " + end + "<br>" +
                "Koszty całkowite: " + totalCosts + " zł <br>" +
                "Pensje pracowników: " + sumTask.toString() + " zł <br>" +
                "Pozostałe wydatki: " + sumExpense.toString() + " zł <br>" ;
    }

}
