package com.codeone.sample.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sample {
	@Id
	public String id;
	public String name;
	public String surname;
	public String zipCode;
	public String address;
	public Boolean active;
}
