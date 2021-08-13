package com.example.catPhoto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.catPhoto.Dao.mapperInterface;

@Controller
public class indexController {
	@GetMapping("/")
	public String getIndex() {
		return "index";
		
	}
	
	@Autowired
	mapperInterface mapperInterface;
	
	@PostMapping("/postIndex")
	public String postIndex(@RequestParam String text,Model mav) {
		mav.addAttribute("text",text);
		String message = mapperInterface.findAll();
		System.out.println(message);
		mapperInterface.insertNewText("初めまして");
		return "index";
	}
}
