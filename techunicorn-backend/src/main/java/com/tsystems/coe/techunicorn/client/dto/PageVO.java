package com.tsystems.coe.techunicorn.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Page VO Class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageVO {

	private int number;
	private int size;
	private int totalElements;
	private int totalPages;

}
