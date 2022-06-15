package firstproject.javaspringboot.controllers;

import firstproject.javaspringboot.db.DBManager;
import firstproject.javaspringboot.db.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/details/{id}")
    public String productDetails(@PathVariable Long id,
                                 Model model) {
        model.addAttribute("product", db.getProduct(id));
        return "productDetails";
    }

    @PostMapping(value = "/addProduct")
    public String addProduct(@RequestParam(name = "pName", defaultValue = "null") String name,
                             @RequestParam(name = "pDescription", defaultValue = "null") String description,
                             @RequestParam(name = "pPrice", defaultValue = "0") int price,
                             Model model) {
        Products product = new Products(null, name, description, price);
        model.addAttribute("products", db.getAllProducts());
        db.addProduct(product);
        return "redirect:/";
    }

    @GetMapping(value = "/addProduct")
    public String addProduct() {
        return "addProduct";
    }

    @GetMapping(value = "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        db.deleteProduct(id);
        return "redirect:/";
    }
}