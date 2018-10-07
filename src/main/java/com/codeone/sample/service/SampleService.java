package com.codeone.sample.service;

import java.util.List;

import com.codeone.sample.dto.SampleDTO;

public interface SampleService {

	SampleDTO getSample(String id);
	List<SampleDTO> getAllSamples();
	SampleDTO updateSample(SampleDTO sample);
	void removeSample(String id);
}
