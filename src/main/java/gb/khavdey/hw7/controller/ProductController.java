package gb.khavdey.hw7.controller;

import gb.khavdey.hw7.model.Product;
import gb.khavdey.hw7.service.ProductService;
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
        model.addAttribute("product", productService.findById(id));
        return "product";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(new Product(null, product.getTitle(), product.getCost()));
        return "redirect:/product";
    }

    @GetMapping ("/index/{id}")
    public String delete(@PathVariable Integer id) {
        productService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/person/{id}")
    public String findByPersonId(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findByPersonId(id));
        return "product";
    }

    @GetMapping("/person/name")
    public String findByPersonName(@RequestParam String name, Model model) {
        model.addAttribute("product", productService.findByPersonName(name));
        return "product";
    }

}
