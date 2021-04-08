package com.paul.employee;

import com.paul.employee.proxy.api.EmployeeApi;
import com.paul.employee.proxy.models.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
@AllArgsConstructor
public class EmployeeClientApplication implements CommandLineRunner {

	EmployeeApi employeeApi;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		employeeApi.findEmployeesUsingGet()
		.stream()
		.forEach(employee -> log.info(employee.getNombre() + " - " + employee.getRol()));

	}

}
