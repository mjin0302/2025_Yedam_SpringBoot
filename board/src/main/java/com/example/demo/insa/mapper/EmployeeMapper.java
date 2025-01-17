package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.EmpDTO;
import com.example.demo.insa.service.EmpSearchDTO;

public interface EmployeeMapper {

	public int insert(EmpDTO dto);

	public int update(EmpDTO dto);

	public int delete(Long empId);

	public List<EmpDTO> getList();
	//public List<EmpDTO> getList(EmpSearchDTO searchDto);

	public EmpDTO read(Long empId);

	public int getCount(EmpDTO dto);

}
