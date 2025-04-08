package com.tsystems.coe.techunicorn.client.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Test VO Class.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestVO {

	private String id;
	private String name;
	private List<String> skills;
	private Integer durationInMinutes;
	private LinkSelfVO _links;

}
