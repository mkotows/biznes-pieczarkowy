package pl.coderslab.pieczarki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/raport")
public class RaportController {


    @GetMapping
    public String getRaports(){


        return "/raport/listRaport";
    }

}
