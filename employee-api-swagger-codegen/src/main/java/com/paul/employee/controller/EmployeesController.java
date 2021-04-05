package com.paul.employee.controller;

import com.paul.employee.api.EmployeesApi;
import com.paul.employee.models.Employee;
import com.paul.employee.models.EmployeePadres;
import com.paul.employee.models.PatchEmployeeRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeesController implements EmployeesApi {
    @Override
    public ResponseEntity<List<Employee>> findEmployeesUsingGet() {
        return ResponseEntity.ok(Arrays.asList(
                new Employee()
                        .id(1l)
                        .nombre("Erika")
                        .edad(28l)
                        .rol("Analista")
                .padres(Arrays.asList(new EmployeePadres()
                                .nombre("Omar Romero")
                        .dni("dni1")
                        .parentesco("Padre"),
                        new EmployeePadres()
                                .nombre("Gloria Sanabria")
                .dni("dni2")
                .parentesco("Madre"))),
                new Employee()
                        .id(2l)
                        .nombre("Paul")
                        .edad(30l)
                        .rol("Arquitecto")
                        .padres(Arrays.asList(new EmployeePadres()
                                        .nombre("William Zacarias")
                                        .dni("dni1")
                                        .parentesco("Padre"),
                                new EmployeePadres()
                                        .nombre("Elizabeth Fabian")
                                        .dni("dni2")
                                        .parentesco("Madre")))));
    }

    @Override
    public ResponseEntity<Void> updateEmployeesUsingPatch(@Valid PatchEmployeeRequest body, String id) {
        return ResponseEntity.noContent().build();
    }
}
