package com.example.demo.common;

import java.util.List;

import lombok.Data;

@Data
public class GridData<T> {
	
	List<T> createRows;
	List<T> deletedRows;
	List<T> updateRows;
	
}
