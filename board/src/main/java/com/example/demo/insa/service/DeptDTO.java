package com.example.demo.insa.service;

import lombok.Data;

@Data
public class DeptDTO {
	private int departmentId;	// 부서번호
	private String departmentName;	// 부서명
	private int managerId;	// 관리자
	private int locationId;	// 지역코드
}
