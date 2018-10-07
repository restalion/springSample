package com.codeone.sample.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeone.sample.dto.SampleDTO;
import com.codeone.sample.entity.Sample;
import com.codeone.sample.repository.SampleRepository;
import com.codeone.sample.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired
	SampleRepository repository;
	
	private DozerBeanMapper mapper = new DozerBeanMapper();

	@Override
	public List<SampleDTO> getAllSamples() {
		List<SampleDTO> out = new ArrayList<>();
 		repository.findAll().forEach(s -> out.add(mapper.map(s, SampleDTO.class)));
		return out;
	}

	@Override
	public SampleDTO getSample(String id) {
		log.debug("Get sample: " + id);
		Optional<Sample> sample = repository.findById(id);
		return mapper.map(sample.get(), SampleDTO.class);
	}

	@Override
	public SampleDTO updateSample(SampleDTO sample) {
		log.debug("Update sample " + sample);
		Sample sampleEntity = mapper.map(sample, Sample.class);
		log.debug("Update sample entity" + sampleEntity);
		Sample updatedSampleEntity = repository.save(sampleEntity);
		log.debug("Updated sample entity" + sampleEntity);
		SampleDTO updatedSample = mapper.map(updatedSampleEntity, SampleDTO.class);
		log.debug("Updated sample dto" + updatedSample);
		return updatedSample;
	}

	@Override
	public void removeSample(String id) {
		repository.deleteById(id);
	}

}
