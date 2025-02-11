package com.example.demo.insa.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ReportCOntroller {
	
	@Autowired
	DataSource source;
	
	@GetMapping("fileDown")
	public void fileDown(HttpServletResponse response) throws IOException {
		FileInputStream fi = new FileInputStream("c:/Temp/data.txt");
		
		int readByte;
		
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		response.setHeader("Content-Disposition", "attachment; filename=" + "data.txt");
		
		while((readByte = fi.read()) != -1 ) {
			response.getOutputStream().write(readByte);
		}
		
		fi.close();
	}
	
	@GetMapping(value = "pdfView")
	public ModelAndView pdfview(HttpServletResponse response) {
		
		// model.setAttribute("key", "value");
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		return new ModelAndView("pdfView", "filename", "/reports/emp2.jasper");
	}
	
	@GetMapping("empPdf")
	public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 레포트 파일
		InputStream jasperStream = getClass().getResourceAsStream("/reports/emp2.jasper");
		
		// 레포트 + 데이터(conn) => 완성
		Connection conn = source.getConnection();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, null, conn);
		conn.close();
		
		// pdf 출력
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
}
