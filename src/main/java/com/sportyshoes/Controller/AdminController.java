package com.sportyshoes.Controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportyshoes.Model.Admin;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("")  // http://localhost/admmin
	public String adminLoginPage() {
		
		return "adminLoginPage";
	}
	
	@PostMapping("")
	@ResponseBody
	public String adminLogin(@RequestParam Map<String, String> req) {
		
		System.out.println(req);
		return "wharrr:";
	}
	
}
