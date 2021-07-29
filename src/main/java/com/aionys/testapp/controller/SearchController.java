package com.aionys.testapp.controller;

import com.aionys.testapp.service.SearchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import java.io.IOException;

@Controller
@RequestMapping("/people")
public class SearchController {

    private final SearchingService searchingService;

    @Autowired
    public SearchController(SearchingService searchingService) {
        this.searchingService = searchingService;
    }


    @GetMapping("/get")
    public String getDto(Long id) {
        String s = searchingService.getDto(63L).toString();
        System.out.println(s);
        return  s;
    }
}
