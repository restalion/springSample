package com.codeone.sample.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.codeone.sample.dto.SampleDTO;
import com.codeone.sample.entity.Sample;
import com.codeone.sample.repository.SampleRepository;
import com.codeone.sample.service.SampleService;

@RunWith(SpringRunner.class)
public class SampleServiceImplTest {
	
	private static final int BULK_SIZE = 20;
	
	private DozerBeanMapper mapper = new DozerBeanMapper();
	
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public SampleService employeeService() {
            return new SampleServiceImpl();
        }
    }
    
    @Autowired
    private SampleService sampleService;
    
    @MockBean
    private SampleRepository repository;

	@Test
	public void testGetAllSamples() {
		// given
		List<Sample> samples = loadBulkData(BULK_SIZE);
		Mockito.when(repository.findAll()).thenReturn(samples);
		
		// when
		List<SampleDTO> dtoSamples = sampleService.getAllSamples();
		
		// then
		assertThat(dtoSamples.size() == samples.size());
		for (int i = 0; i < BULK_SIZE; i++) {
			assertThat(dtoSamples.get(i).equals(mapper.map(samples.get(i), SampleDTO.class)));
		}
	}

	@Test
	public void testGetSample() {
		// given
		List<Sample> samples = loadBulkData(1);
		Optional<Sample> sample = Optional.of(samples.get(0));
		Mockito.when(repository.findById("1")).thenReturn(sample);
		
		// when
		SampleDTO dtoSample = sampleService.getSample("1");
		
		// then
		assertThat(dtoSample != null);
		assertThat(dtoSample.equals(mapper.map(sample.get(), SampleDTO.class)));
	}

	@Test
	public void testUpdateSample() {
		// given
		List<Sample> samples = loadBulkData(1);
		Mockito.when(repository.save(samples.get(0))).thenReturn(samples.get(0));
		
		// when
		SampleDTO dtoSample = sampleService.updateSample(mapper.map(samples.get(0), SampleDTO.class));
		
		// then
		assertThat(dtoSample != null);
		assertThat(dtoSample.equals(mapper.map(samples.get(0), SampleDTO.class)));
	}

	@Test
	public void testRemoveSample() {
		// given

		// when
		sampleService.removeSample("1");
		
		// then
	}
	
	private List<Sample> loadBulkData(int size) {
		List<Sample> values = new ArrayList<>();
		Sample sample;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				sample = Sample.builder()
						.active(Boolean.TRUE)
						.address("Test address " + i)
						.name("Test name " + i)
						.surname("Test surname " + i)
						.zipCode("" + i)
						.id("" + i)
						.build();
				values.add(sample);
			}
		}
		return values;
	}

}
