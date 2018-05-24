package pl.coderslab.pieczarki.controller;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.pieczarki.model.MushroomHall;
import pl.coderslab.pieczarki.model.Task;
import pl.coderslab.pieczarki.repository.MushroomHallRepository;
import pl.coderslab.pieczarki.repository.TaskRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/mushroomHall")
public class MushroomHallController {

    @Autowired
    MushroomHallRepository mushroomHallRepository;
    @Autowired
    TaskRepository taskRepository;

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
        System.out.println(mushroomHall.getName() + " ...1... size: " + mushroomHall.getTasks().size());
        List<Task> tasks = mushroomHall.getTasks();
        for (Task task: tasks){
            System.out.println("task 1......" + task.getMushroomHall());
        }

        if(mushroomHall==null){
            System.out.println("There are any mushroomHall to delete");
        }  else{

            settingConnectionsToNull(mushroomHall);
            mushroomHallRepository.save(mushroomHall);

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            MushroomHall mushroomHall2 = mushroomHallRepository.getOne(id);
//
//            System.out.println(mushroomHall2.getName() + " ...2... size: " + mushroomHall2.getTasks().size());
//
//            List<Task> tasks2 = mushroomHall.getTasks();
//            for (Task task: tasks2){
//                System.out.println("task 2......" + task.getMushroomHall());
//            }
            mushroomHallRepository.delete(mushroomHall);
        }
        return "redirect:/mushroomHall";
    }

    private void settingConnectionsToNull(MushroomHall mushroomHall) {
        List<Task> tasks = mushroomHall.getTasks();
        for (Task task: tasks){

            task.setMushroomHall(null);
            System.out.println("task......" + task.getMushroomHall());

//            taskRepository.save(task);

        }

        System.out.println(mushroomHall.getName() + " Wewnatrz ...1... size: " + mushroomHall.getTasks().size());

//        TODO dokończyć pisanie ustawiania mushroomHall na null przed usunięciem
    }
}
