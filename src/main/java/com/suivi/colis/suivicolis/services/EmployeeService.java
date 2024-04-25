/*
 * **
 *  * @project : SuiviColis
 *  * @created : 23/04/2024, 19:12
 *  * @modified : 23/04/2024, 19:12
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 *  **
 */

package com.suivi.colis.suivicolis.services;

import com.suivi.colis.suivicolis.models.Employee;
import com.suivi.colis.suivicolis.repositorys.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepository ;

    public void deleteEmployee(Long id) {


        employeeRepository.deleteById(id);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


}
