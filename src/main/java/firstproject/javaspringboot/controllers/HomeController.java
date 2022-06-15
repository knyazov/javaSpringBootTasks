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
        try {
            model.addAttribute("products", db.getAllProducts());
            return "index";
        } catch (Exception e) {
            return "redirect:/notFound";
        }
    }

    @GetMapping(value = "/details/{id}")
    public String productDetails(@PathVariable Long id,
                                 Model model) {
        try {
            model.addAttribute("product", db.getProduct(id));
            return "productDetails";
        } catch (Exception e) {
            return "redirect:/notFound";
        }
    }

    @PostMapping(value = "/details/{id}")
    public String productDetails(@RequestParam(name = "pName", defaultValue = "null") String name,
                                 @RequestParam(name = "pDescription", defaultValue = "null") String description,
                                 @RequestParam(name = "pPrice", defaultValue = "0") double price) {
        try {
            Products product = new Products(null, name, description, price);
            db.addProduct(product);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/notFound";
        }
    }

    @PostMapping(value = "/addProduct")
    public String addProduct(@RequestParam(name = "pName", defaultValue = "null") String name,
                             @RequestParam(name = "pDescription", defaultValue = "null") String description,
                             @RequestParam(name = "pPrice", defaultValue = "0") double price) {
        try {
            Products product = new Products(null, name, description, price);
            db.addProduct(product);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/notFound";
        }
    }

    @GetMapping(value = "/addProduct")
    public String addProduct() {
        return "addProduct";
    }

    @GetMapping(value = "/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        try {
            db.deleteProduct(id);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/notFound";
        }
    }

    @GetMapping(value = "/notFound")
    public String notFound() {
        return "notFound";
    }
}