package com.shamonin.catalog.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class PagesController {
    @GetMapping
    String returnCatalog(){
        return "catalog";
    }
}
