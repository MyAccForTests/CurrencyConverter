package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ilua on 11.01.2017.
 */
@Controller
@RequestMapping(value = "/")
public class PagesController {

    @GetMapping
    public String getIndex() {
        return "index";
    }
}
