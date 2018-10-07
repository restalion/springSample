package com.codeone.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleDTO {
	public String id;
	public String name;
	public String surname;
	public String zipCode;
	public String address;
	public Boolean active;
}
