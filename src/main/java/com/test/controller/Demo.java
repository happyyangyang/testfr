package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/demo")
public class Demo {
	    
	    @RequestMapping(value = "/sendContacts", method = RequestMethod.GET)
	    public String sendContents(@RequestParam(value = "contacts[]") String[] contacts){
	        //Stream.of(contacts).forEach(System.out::println);
	        return "SUCCESS";
	    }

}
