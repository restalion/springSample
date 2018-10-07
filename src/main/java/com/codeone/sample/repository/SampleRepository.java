package com.codeone.sample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codeone.sample.entity.Sample;

public interface SampleRepository extends MongoRepository<Sample, String>{

}
