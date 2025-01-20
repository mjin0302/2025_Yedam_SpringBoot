package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.EmpDTO;
import com.example.demo.insa.service.JobsDTO;

public interface EmployeeMapper {

	// 등록
	public int insert(EmpDTO dto);

	// 수정
	public int update(EmpDTO dto);

	// 삭제
	public int delete(Long empId);

	// 전체조회
	public List<EmpDTO> getList();
	//public List<EmpDTO> getList(EmpSearchDTO searchDto);

	// 단건조회
	public EmpDTO read(Long empId);

	// 총 사원수
	public int getCount(EmpDTO dto);

	// 역할조회
	public List<JobsDTO> getJobs();

}
