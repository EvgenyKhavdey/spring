package gb.spring.lesson4.controller;

import gb.spring.lesson4.model.Product;
import gb.spring.lesson4.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("product", productService.findAll());
        return "product";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        model.addAttribute("persons", productService.findById(id));
        return "product";
    }

    @PostMapping
    public String save(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping ("/index/{id}")
    public String delete(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/product";
    }
}
