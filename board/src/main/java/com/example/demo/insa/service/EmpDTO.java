package com.example.demo.insa.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
	private Long employeeId;		// 사원아이디
    private String firstName;	 	// 이름
    private String lastName;		// 이름
    private String email;			// 이메일
    private String phoneNumber;		// 전화번호
    private Date hireDate;			// 입사일
    private String jobId;			// 직업
    private Long salary;			// 연봉
    private double commissionPct;	// 상여금
    private Long managerId;			// 관리자
    private Long departmentId;		// 부서
}
