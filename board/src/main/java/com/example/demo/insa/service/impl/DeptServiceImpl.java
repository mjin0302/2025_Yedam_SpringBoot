package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.DeptMapper;
import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptSearchDTO;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeptServiceImpl implements DeptService {
	
	@Autowired DeptMapper mapper;
	
	// 전체조회
	@Override
	public List<DeptDTO> getList(DeptSearchDTO dto) {
		return mapper.getList(dto);
	}
	
	// 단건조회
	@Override
	public DeptDTO read(int departmentId) {
		return mapper.read(departmentId);
	}

}
