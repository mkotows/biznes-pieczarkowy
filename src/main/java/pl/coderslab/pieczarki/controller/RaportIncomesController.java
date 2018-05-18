package pl.coderslab.pieczarki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.pieczarki.model.Income;
import pl.coderslab.pieczarki.model.MushroomHall;
import pl.coderslab.pieczarki.repository.IncomeRepository;
import pl.coderslab.pieczarki.repository.MushroomHallRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("raport/incomes")
public class RaportIncomesController {

    @Autowired
    IncomeRepository incomeRepository;
    @Autowired
    MushroomHallRepository mushroomHallRepository;

    @ModelAttribute("mushroomHalls")
    public List<MushroomHall> getMushroomHalls() {
        return mushroomHallRepository.findAll();
    }

    @GetMapping
    public String getRaports() {
        return "raport/listRaportIncomes";
    }

    @PostMapping("/one")
    public String reportForOneHall(Model model,
                                   @RequestParam String hallId,
                                   @RequestParam String start,
                                   @RequestParam String end
    ) {
        MushroomHall mushroomHall = mushroomHallRepository.getOne(Long.valueOf(hallId));
        Date start1 = Date.valueOf(start);
        Date end1 = Date.valueOf(end);

        List<Income> list = incomeRepository.findAllByMushroomHallAndDateBetween(mushroomHall,start1, end1);

        String resultText = generateText(start, end, list);


        model.addAttribute("resultText", resultText);
        model.addAttribute("list", list);

        return "raport/listResultIncomes";
    }

    @PostMapping("/all")
    public String reportForOneHall(Model model,
                                   @RequestParam String start,
                                   @RequestParam String end
    ) {
        Date start1 = Date.valueOf(start);
        Date end1 = Date.valueOf(end);

        List<Income> list = incomeRepository.findAllByDateBetween(start1, end1);

        String resultText = generateText(start, end, list);


        model.addAttribute("resultText", resultText);
        model.addAttribute("list", list);

        return "raport/listResultIncomes";
    }



    private String generateText(String start, String end, List<Income> list) {

        BigDecimal totalIncome = new BigDecimal(0);

        for(Income income: list){
            totalIncome=totalIncome.add(income.getTotalIncome());
        }

        return "Raport dla okresu od " + start + " do " + end + "<br>" +
                "Przychód: " + totalIncome.toString() + " zł <br>";

    }


}
