package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.EmployeeMapper;
import com.example.demo.insa.service.EmpDTO;
import com.example.demo.insa.service.EmpSearchDTO;
import com.example.demo.insa.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired EmployeeMapper eMapper;
	
	// 등록
	@Override
	public boolean insert(EmpDTO dto) {
		return eMapper.insert(dto) == 1 ? true : false;
	}

	// 수정
	@Override
	public boolean update(EmpDTO dto) {
		return eMapper.update(dto) == 1 ? true : false;
	}

	// 삭제
	@Override
	public boolean delete(Long empId) {
		return eMapper.delete(empId) == 1 ? true : false;
	}

	// 전체조회
	@Override
	public List<EmpDTO> getList() {
		return eMapper.getList();
	}
	
	// 전체조회
//	@Override
//	public List<EmpDTO> getList(EmpSearchDTO searchDto) {
//		return eMapper.getList(searchDto);
//	}

	// 단건조회
	@Override
	public EmpDTO read(Long empId) {
		return eMapper.read(empId);
	}

	// 총 사원수
	@Override
	public int getCount(EmpDTO dto) {
		return eMapper.getCount(dto);
	}

}
