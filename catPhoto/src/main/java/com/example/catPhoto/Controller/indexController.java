package com.example.catPhoto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.catPhoto.Dao.mapperInterface;
import com.example.catPhoto.Entity.messagesEntity;
import com.example.catPhoto.Form.indexForm;

@Controller
public class indexController {
	@GetMapping("/")
	public String getIndex() {
		return "index";
		
	}
	
	@Autowired
	mapperInterface mapperInterface;
	@Autowired
	indexForm indexForm;
	
	@PostMapping("/postIndex")
	public String postIndex(@RequestParam String text,Model mav) {
		indexForm.setText(text);
		mav.addAttribute("text",indexForm.getText());
		List<messagesEntity> message = mapperInterface.findAll();
		for(messagesEntity msg:message) {
			System.out.println(msg);
		}
		message.get(0);
		//		System.out.println(message);
		mapperInterface.insertNewText(indexForm.getText());
		return "index";
	}
}
