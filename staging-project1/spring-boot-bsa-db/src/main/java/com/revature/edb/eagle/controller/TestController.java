package com.revature.edb.eagle.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String test(){
        return "/hello this is ben burke";
    }


}
