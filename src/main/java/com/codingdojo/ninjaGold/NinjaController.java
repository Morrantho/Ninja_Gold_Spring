package com.codingdojo.ninjaGold;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaController {
	public ArrayList< Location > activities = new ArrayList< Location >();
	
	@GetMapping("/")
	public String root( Model model, HttpSession session ){
		if( session.getAttribute("gold") == null ) {
			session.setAttribute("gold",0);
		}
		
		model.addAttribute("activities",activities);
		
		return "ninjas";
	}

	@PostMapping("/")
	public String process( @RequestBody() String postData, HttpSession session ){
		String location = postData.substring(0, postData.indexOf("=") );
		Random random = new Random();
		int n = 0;
		int gold = (int) session.getAttribute("gold");
		String text = "You entered a ";
		String gained = "gained";
		
		switch(location){
			case "casino":
				n = random.nextInt(50);
				n = random.nextInt(10)+10;n = random.nextInt(10)+10;
				if( random.nextInt(2) == 1) {
					n = -n;
					gained = "lost";
				}
				
				break;
			case "farm":
				n = random.nextInt(10)+10;
				break;
			case "house":
				n = random.nextInt(3)+2;
				break;
			case "cave":
				n = random.nextInt(5)+5;
				break;
		}
		text += location+" and "+gained+" gold "+gold;
		gold += n;
		session.setAttribute("gold",gold);
		
		Location newLocation = new Location( location, n );
		
		activities.add( newLocation );
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}