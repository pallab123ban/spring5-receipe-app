package guru.springframework.receipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is index controller class.
 * @author PALLAB
 */
@Controller
public class IndexController {

    @RequestMapping({"","/","/index"})
    public String getIndexPage() {
        return "index";
    }
}
