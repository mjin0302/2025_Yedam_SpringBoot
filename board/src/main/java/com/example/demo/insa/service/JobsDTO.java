package com.example.demo.insa.service;

import lombok.Data;

@Data
public class JobsDTO {
	private String jobId;	// 업종 코드
	private String jobTitle;// 업종명
	private Long minSalary;	// 최소연봉
	private Long maxSalary;	// 최대연봉
}
