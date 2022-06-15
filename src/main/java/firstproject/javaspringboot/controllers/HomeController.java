package firstproject.javaspringboot.controllers;

import firstproject.javaspringboot.db.DBManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
//@RequestMapping(value = "chapter1")
public class HomeController {
    private final DBManager db;

    @GetMapping(value = "/")
    public String indexPage(Model model) {
        model.addAttribute("products", db.getAllProducts());
        return "index";
    }
}
