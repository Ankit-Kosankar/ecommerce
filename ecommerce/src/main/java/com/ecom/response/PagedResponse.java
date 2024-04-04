package com.ecom.response;

import java.util.List;

import lombok.Data;

@Data
public class PagedResponse<T> 
{
	private List<T> content;
	private Boolean lastPage;
	private Long totalPageCount;

	public PagedResponse() {
		super();
	}	
	
	public PagedResponse(List<T> content, Boolean lastPage, Long totalPageCount) {
		super();
		this.content = content;
		this.lastPage = lastPage;
		this.totalPageCount = totalPageCount;
	}
}
