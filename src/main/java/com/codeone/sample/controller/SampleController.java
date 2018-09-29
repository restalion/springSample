package com.codeone.sample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@PostMapping("/samplePost")
	public void samplePost() {
		
	}
	
	@GetMapping("/sampleGet")
	public void sampleGet() {
		
	}

}
