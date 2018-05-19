package pl.coderslab.pieczarki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.pieczarki.model.Expense;
import pl.coderslab.pieczarki.model.Income;
import pl.coderslab.pieczarki.model.MushroomHall;
import pl.coderslab.pieczarki.model.Task;
import pl.coderslab.pieczarki.repository.ExpenseRepository;
import pl.coderslab.pieczarki.repository.IncomeRepository;
import pl.coderslab.pieczarki.repository.MushroomHallRepository;
import pl.coderslab.pieczarki.repository.TaskRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/raport")
public class RaportController {

    @Autowired
    IncomeRepository incomeRepository;
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    MushroomHallRepository mushroomHallRepository;
    @Autowired
    TaskRepository taskRepository;

    @ModelAttribute("mushroomHalls")
    public List<MushroomHall> getMushroomHalls() {
        return mushroomHallRepository.findAll();
    }

    @GetMapping
    public String getRaports() {
        return "raport/listRaportTotal";
    }

    @PostMapping("/one")
    public String reportForOneHall(Model model,
                                   @RequestParam String hallId,
                                   @RequestParam String start,
                                   @RequestParam String end
    ){


        MushroomHall mushroomHall = mushroomHallRepository.getOne(Long.parseLong(hallId));

        Date start1 = Date.valueOf(start);
        Date end1 =  Date.valueOf(end);
        List<Expense> expenses = expenseRepository.findAllByMushroomHallAndDateBetween(mushroomHall,start1, end1);
        List<Task> tasks = taskRepository.findAllByMushroomHallAndDateBetween(mushroomHall,start1, end1);
        List<Income> incomes = incomeRepository.findAllByMushroomHallAndDateBetween(mushroomHall,start1,end1);

        String resultText = "Wynik finansowy dla hali: " + mushroomHall.getName() + "<br>";
        resultText = resultText + getResultText(start, end, expenses, tasks, incomes);

        model.addAttribute("expenses",expenses);
        model.addAttribute("tasks",tasks);
        model.addAttribute("incomes", incomes);
        model.addAttribute("resultText",resultText);

        return "raport/listResultTotal";
    }

    @PostMapping("/all")
    public String reportForOneHall(Model model,
                                   @RequestParam String start,
                                   @RequestParam String end
    ){


        Date start1 = Date.valueOf(start);
        Date end1 =  Date.valueOf(end);
        List<Expense> expenses = expenseRepository.findAllByDateBetween(start1, end1);
        List<Task> tasks = taskRepository.findAllByDateBetween(start1, end1);
        List<Income> incomes = incomeRepository.findAllByDateBetween(start1,end1);

        String resultText = "Wynik finansowy dla wszystkich hal <br>";
        resultText = resultText + getResultText(start, end, expenses, tasks, incomes);

        model.addAttribute("expenses",expenses);
        model.addAttribute("tasks",tasks);
        model.addAttribute("incomes", incomes);
        model.addAttribute("resultText",resultText);

        return "raport/listResultTotal";
    }

    private String getResultText(String start, String end, List<Expense> expenses, List<Task> tasks, List<Income> incomes) {

        BigDecimal total = new BigDecimal(0);
        BigDecimal totalIncome = new BigDecimal(0);
        BigDecimal totalExpense = new BigDecimal(0);
        StringBuilder resultText = new StringBuilder();


        for (Income income: incomes){
            totalIncome=totalIncome.add(income.getTotalIncome());
        }

        for(Expense expense: expenses){
            totalExpense=totalExpense.add(expense.getCost());
        }

        for(Task task: tasks){
            totalExpense=totalExpense.add(task.getCost());
        }

        total = totalIncome.subtract(totalExpense);

        resultText.append("Wynik finansowy dla okresu od " + start + " do " + end + " <br><br>");

        double financeResult = total.doubleValue();

        if (financeResult<0){
            total=total.abs();
            resultText.append("Straty wyniosły: "+ total.toString() + "zł <br><br>");
        } else if (financeResult>0){
            resultText.append("Dochód wyniósł: " + total.toString() +" zł <br><br>");
        } else{
            resultText.append("Brak dochodów, wynik: 0zł <br><br>");
        }

        resultText.append("Przychody: " + totalIncome.toString() + " zł <br>");
        resultText.append("Starty: " + totalExpense.toString() + " zł <br>");

        return resultText.toString();
    }

}
