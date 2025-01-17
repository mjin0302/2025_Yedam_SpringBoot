package com.example.demo.insa.service;

import java.util.List;

public interface EmployeeService {
	// 등록
	public boolean insert(EmpDTO dto);
	
	// 수정
	public boolean update(EmpDTO dto);
	
	// 삭제
	public boolean delete(Long empId);
	
	// 전체조회
	public List<EmpDTO> getList();
	
	// 전체조회
	//public List<EmpDTO> getList(EmpSearchDTO searchDto);
	
	// 단건조회
	public EmpDTO read(Long empId);
	
	// 총 사원수
	public int getCount(EmpDTO dto);
	
}
