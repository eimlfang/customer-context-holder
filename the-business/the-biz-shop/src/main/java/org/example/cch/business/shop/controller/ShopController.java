package org.example.cch.business.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business/shop")
public class ShopController {
    @GetMapping("/item-list")
    public List<String> getItemList() {
        return List.of("item1", "item2", "item3");
    }
}
