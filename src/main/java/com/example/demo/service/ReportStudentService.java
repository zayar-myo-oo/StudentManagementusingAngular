package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.example.demo.dto.Student;
import com.example.demo.dto.User;
import com.example.demo.repo.StudentRepo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
@Service
public class ReportStudentService {
	@Autowired
	private StudentRepo repo;
	public String exportPdfReport (String reportFormat) throws FileNotFoundException, JRException {
		String path="C:\\Users\\ACER\\Desktop";
		List<Student> stu=(List<Student>) repo.findAll();
		//Load file and complie it
//		File file=ResourceUtils.getFile("classpath:stuList.jrxml");
		File file=ResourceUtils.getFile("classpath:studentAllLists.jrxml");
		JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(stu);
		Map<String,Object> parameters=new HashMap<>();
		parameters.put("createdBy", "ZayarMyoOo");
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, parameters,dataSource);
		
		
//		export pdf
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\StudentList.pdf");
		}
		
		return "report generated in path :"+path;
	}

	public String exportExcelReport(HttpServletResponse response) throws JRException, IOException{
		String path="C:\\Users\\ACER\\Desktop";
		List<Student> stu=(List<Student>) repo.findAll();
	    System.out.println(stu.toString());
//	    File file=ResourceUtils.getFile("classpath:stuList.jrxml");
	    File file=ResourceUtils.getFile("classpath:studentAllLists.jrxml");
	    JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
	    JRBeanCollectionDataSource dataSource=new JRBeanCollectionDataSource(stu);
	    Map<String,Object>  parameters=new HashMap<>();
	    parameters.put("createdBy", "ZayarMyoOo");
	    JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport,parameters, dataSource);
	    
	    
//	    export excel
	    JRXlsxExporter exporter = new JRXlsxExporter();
	    exporter.setExporterInput( new SimpleExporterInput(jasperPrint));
	    exporter.setExporterOutput( new SimpleOutputStreamExporterOutput(path + "\\StudentList.xlsx" ));

	    SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
	    config.setOnePagePerSheet( true );
	    config.setDetectCellType( true );
	    exporter.setConfiguration( config );
	    exporter.exportReport();
	    
	    return "report generated in path :"+path;
	}
	}