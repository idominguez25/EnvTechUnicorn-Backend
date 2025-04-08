package com.tsystems.coe.techunicorn.client.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LinksSelf VO Class.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkSelfVO {

	private Map<String, String> self;

}
