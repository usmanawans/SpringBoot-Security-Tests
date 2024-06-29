package no.norbay.springbootsecuritytests.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @RequestMapping("/open")
    public String open(){
        return "Publically open endpoint";
    }

    @RequestMapping("/close")
    public String close(){
        return "Privately closed endpoint";
    }
}
