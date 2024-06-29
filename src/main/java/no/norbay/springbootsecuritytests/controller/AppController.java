package no.norbay.springbootsecuritytests.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AppController {

    @RequestMapping("/open")
    public String open(){
        return "Publically open endpoint";
    }

    @RequestMapping("/close")
    public String close(Principal principal){
        return "Welcome "+ principal.getName() +". Privately closed endpoint. You role is "+ principal.toString();
    }
}
