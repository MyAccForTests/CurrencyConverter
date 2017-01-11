package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ilua on 11.01.2017.
 */
@RestController
public class PagesController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String currencyconverter() {
        return "CurrencyConverterMainPage";
    }
}
