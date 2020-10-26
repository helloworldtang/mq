package com.tangcheng.mq.rabbit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {


    @GetMapping({"", "/", "index", "home", "swagger-ui.html"})
    public String index() {
        log.info("IndexController index");
        return "redirect:swagger-ui/index.html";
    }


}
