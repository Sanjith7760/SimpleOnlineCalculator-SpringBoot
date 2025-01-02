package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalciController {

	@Autowired
	CalciService calciService;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@PostMapping("/calculator")
	public String performOperation(@RequestParam("num1") double num1, 
			@RequestParam("num2") double num2, 
			@RequestParam("operation") String operation, 
			Model model) 
	{
		double result=0;
		switch(operation) {
		case "add" -> result= calciService.add(num1, num2);
		case "sub" -> result = calciService.sub(num1, num2);
		case "mul" -> result = calciService.mul(num1, num2);
		case "mod" -> result = calciService.mod(num1, num2);
		case "sqr" -> result = calciService.sqr(num1, num2);
		case "div" -> { if(num2!=0) {
			result = calciService.div(num1, num2);
		} else {
			model.addAttribute("errmsg", "Division by Zero is Not Allowed");
			model.addAttribute("num1", num1);
			model.addAttribute("num2", num2);
			return "result";
		}
		}
		default -> {
			model.addAttribute("error", "Invalid Opearion");
			return "result";
		}
		}

		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("operation", operation);
		model.addAttribute("result", result);
		return "result";

	}
}
