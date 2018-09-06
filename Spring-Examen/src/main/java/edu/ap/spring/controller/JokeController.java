package edu.ap.spring.controller;

import java.net.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("session")
public class JokeController {
   
   public JokeController() {
   }
       
   @RequestMapping(value = "/joke", method = RequestMethod.GET)
   @ResponseBody
   public String joke() {
	   
	   return "Joke";
   }
		   
   @RequestMapping("/joke_post")
   @ResponseBody
   public String joke_post() {
	   URL url = new URL("http://example.com");
	   HttpURLConnection con = (HttpURLConnection) url.openConnection();
	   con.setRequestMethod("GET");
	   return "";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
