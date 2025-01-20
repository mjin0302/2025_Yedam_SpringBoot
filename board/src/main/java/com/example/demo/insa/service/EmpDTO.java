package com.example.demo.insa.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
	
	@NotBlank(message = "성을 입력하세요.")
    private String firstName;	 	// 이름
    
	@NotBlank(message = "이름을 입력하세요.")
    private String lastName;		// 이름
    
    @Email
    @NotBlank(message = "이메일을 입력하세요.")
    private String email;			// 이메일
    
    private String phoneNumber;		// 전화번호
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hireDate;			// 입사일
    
    @NotBlank(message = "역할을 선택하세요.")
    private String jobId;			// 직업
    private Long salary;			// 연봉
    private double commissionPct;	// 상여금
    private Long managerId;			// 관리자
    private Long departmentId;		// 부서
}
