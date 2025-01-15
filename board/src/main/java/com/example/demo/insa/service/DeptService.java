package com.example.demo.insa.service;

import java.util.List;

public interface DeptService {
	
	// 전체조회
	public List<DeptDTO> getList(DeptSearchDTO dto);
	
	// 단건조회
	public DeptDTO read(int departmentId);
}
