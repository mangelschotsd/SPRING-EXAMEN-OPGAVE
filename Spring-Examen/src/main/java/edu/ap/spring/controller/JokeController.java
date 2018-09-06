package edu.ap.spring.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@Scope("session")
public class JokeController {
   
   public JokeController() {
   }
       
   @RequestMapping(value = "/joke")
   public String joke() {
	   return "views/search.html";
   }
		   
   @RequestMapping(value = "/joke_post", method = RequestMethod.POST)
   @ResponseBody
   public String joke_post(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName) {
	   final String uri = "http://api.icndb.com/jokes/random?firstName=" + firstName + 
			   "&lastName=" + lastName;
	   
	   RestTemplate restTemplate = new RestTemplate();
	   String joke = restTemplate.getForObject(uri, String.class);
	   
	   
	   return joke;
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
   
}
