package com.luizmarcelo.jasperexample.service.report;

import com.luizmarcelo.jasperexample.model.employee.Employee;
import com.luizmarcelo.jasperexample.service.employee.EmployeeService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private EmployeeService employeeService;

    public String generateReport() throws FileNotFoundException, JRException {
        String path = "C:\\Users\\luizm\\java-studies\\jasper-example\\reports\\";
        String archiveName = "employees.pdf";
        List<Employee> employees = employeeService.getEmployees();
        File file = ResourceUtils.getFile("classpath:employees.jrxml");
        JasperReport jr = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> params = new HashMap<>();
        params.put("Created By", "Luiz Marcelo");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jr,params,dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, path +archiveName);
        return path + archiveName;
    }

    public File exportReport() throws FileNotFoundException, JRException {
        File file = new File(Paths.get(generateReport()).toUri());
        if(file.exists()){
            return file;
        }
        return null;
    }
}
