package pl.coderslab.pieczarki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.pieczarki.model.MushroomHall;
import pl.coderslab.pieczarki.repository.MushroomHallRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/hall")
public class MushroomHallController {

    @Autowired
    MushroomHallRepository mushroomHallRepository;

    @GetMapping
    public String mushroomHalls(Model model){

        List<MushroomHall> list = mushroomHallRepository.findAll();
        model.addAttribute("list", list);

        return "listMushroomHall";
    }

    @GetMapping("/add")
    public String addMushroomHall(Model model){
        model.addAttribute("mushroomHall", new MushroomHall());
        return "/form/addMushroomHall";
    }


    @PostMapping("/add")
    public String addMushroomHall(@Valid MushroomHall mushroomHall, BindingResult result){
        if (result.hasErrors()){
            return "form/addMushroomHall";
        } else {
            mushroomHallRepository.save(mushroomHall);
            return "redirect:/mushroomHall";
        }
    }

    @GetMapping("/edit/{id}")
    public String editMushroomHall(@PathVariable Long id, Model model){

        MushroomHall mushroomHall = mushroomHallRepository.getOne(id);
        model.addAttribute("mushroomHall", mushroomHall);

        return "form/editMushroomHall";
    }

    @PostMapping("/edit/{id}")
    public String editMushroomHall(@Valid MushroomHall mushroomHall, BindingResult result){
        if(result.hasErrors()){
            return "form/editMushroomHall";
        } else {
            mushroomHallRepository.save(mushroomHall);
            return "redirect:/mushroomHall";
        }

    }

    @GetMapping("/delete/{id}")
    public String deleteMushroomHall(@PathVariable Long id, Model model){

        return "deleteMushroomHall";
    }

    @PostMapping("/delete/{id}")
    public String deleteMushroomHall(@PathVariable Long id){

        MushroomHall mushroomHall = mushroomHallRepository.getOne(id);
        if(mushroomHall==null){
            System.out.println("There are any mushroomHall to delete");
        }  else{
            mushroomHallRepository.delete(mushroomHall);
        }
        return "redirect:/mushroomHall";
    }
}
