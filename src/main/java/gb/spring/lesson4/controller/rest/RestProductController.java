package gb.spring.lesson4.controller.rest;

import gb.spring.lesson4.model.NewProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/new_product")
@RequiredArgsConstructor
public class RestProductController {


    @PostMapping
    public String test(@RequestBody @Valid NewProduct product) {
        return "OK";
    }

}
