package in.dto.DtoPractice.service;

import in.dto.DtoPractice.dto.EmployeeRequestDto;
import in.dto.DtoPractice.dto.EmployeeResponseDto;
import in.dto.DtoPractice.dto.UpdateRequestDto;
import in.dto.DtoPractice.dto.UpdateResponseDto;

import java.util.List;

public interface EmployeeService {
    // To Create Employee
    EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto);
    // Get Employee By id
    EmployeeResponseDto getEmployeeById(Long id);
    // Get All the Employee .
    List<EmployeeResponseDto> getAllEmployees();
    // update Employee
    UpdateResponseDto updateEmployee(UpdateRequestDto updateRequestDto , Long id);
    // soft Delete .
    String softDeleteEmployee(Long id);
    // Delete Employee.
    void deleteEmployeeById(Long id);


}
