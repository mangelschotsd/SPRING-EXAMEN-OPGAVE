package edu.ap.spring.controller;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
	   URL url;
	try {
		url = new URL("http://example.com");
		   HttpURLConnection con = (HttpURLConnection) url.openConnection();
		   con.setRequestMethod("GET");
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return "";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
