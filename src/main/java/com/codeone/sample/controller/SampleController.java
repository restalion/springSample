package com.codeone.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeone.sample.dto.SampleDTO;
import com.codeone.sample.service.SampleService;

@RestController
public class SampleController {
	
	@Autowired
	SampleService service;
	
	@PostMapping("/samplePost")
	public SampleDTO samplePost(@RequestBody SampleDTO sampleDto) {
		return service.updateSample(sampleDto);
	}
	
	@GetMapping("/sampleGet")
	public SampleDTO sampleGet(@RequestParam String id) {
		return service.getSample(id);
	}
	
	@GetMapping("/sampleGetAll")
	public List<SampleDTO> sampleGet() {
		return service.getAllSamples();
	}
	
	@DeleteMapping("/sampleDelete")
	public Boolean sampleDelete(@RequestParam String id) {
		service.removeSample(id);
		return Boolean.TRUE;
	}
}
