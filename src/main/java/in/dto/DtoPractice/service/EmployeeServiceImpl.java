package in.dto.DtoPractice.service;

import in.dto.DtoPractice.dto.EmployeeRequestDto;
import in.dto.DtoPractice.dto.EmployeeResponseDto;
import in.dto.DtoPractice.dto.UpdateRequestDto;
import in.dto.DtoPractice.dto.UpdateResponseDto;
import in.dto.DtoPractice.entity.Employee;
import in.dto.DtoPractice.exception.ResourceNotFoundException;
import in.dto.DtoPractice.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = requestToEntity(employeeRequestDto);
        repository.save(employee);
        return entityToResponse(employee);
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Invalid Employee Id " + id));
        return entityToResponse(employee);
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        return List.of();
    }

    @Override
    public UpdateResponseDto updateEmployee(UpdateRequestDto updateRequestDto, Long id) {
        Employee employee = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Invalid id  id : " + id));
        updateEmployeeInternal(updateRequestDto,employee);
        return entityToUpdateResponse(employee);
    }

    @Override
    public String softDeleteEmployee(Long id) {
        Employee employee = repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Invalid id : " + id));
        employee.setDeleted(false);
        return "Employee has been deleted successfully";
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Invalid id of employee : " + id));
        repository.deleteById(employee.getId());
    }

    private Employee updateEmployeeInternal(UpdateRequestDto updateRequestDto , Employee employee){
        employee.setCreatedAt(LocalDateTime.now());
        employee.setDeleted(false);
        employee.setFatherName(updateRequestDto.getFatherName());
        employee.setName(updateRequestDto.getName());
        employee.setPhoneNo(updateRequestDto.getPhoneNo());
        employee.setRoles(updateRequestDto.getRoles());
        employee.setUpdatedAt(LocalDateTime.now());
        employee.setUsername(updateRequestDto.getUsername());
        return employee;
    }

    private Employee requestToEntity(EmployeeRequestDto employeeRequestDto){
        Employee employee = Employee.builder()
                .createdAt(LocalDateTime.now())
                .deleted(false)
                .email(employeeRequestDto.getEmail())
                .fatherName(employeeRequestDto.getFatherName())
                .name(employeeRequestDto.getName())
                .phoneNo(employeeRequestDto.getPhoneNo())
                .roles(employeeRequestDto.getRoles())
                .updatedAt(LocalDateTime.now())
                .username(employeeRequestDto.getUsername())
                .build();
        return employee;
    }

    private EmployeeResponseDto entityToResponse(Employee employee){
        EmployeeResponseDto dto = EmployeeResponseDto.builder()
                .createdAt(LocalDateTime.now())
                .email(employee.getEmail())
                .fatherName(employee.getFatherName())
                .name(employee.getName())
                .phoneNo(employee.getPhoneNo())
                .roles(employee.getRoles())
                .updatedAt(employee.getCreatedAt())
                .username(employee.getUsername())
                .id(employee.getId())
                .build();
        return dto;
    }

    private UpdateResponseDto entityToUpdateResponse(Employee employee){
        UpdateResponseDto updateResponseDto = UpdateResponseDto.builder()
                .email(employee.getEmail())
                .fatherName(employee.getFatherName())
                .name(employee.getName())
                .id(employee.getId())
                .phoneNo(employee.getPhoneNo())
                .roles(employee.getRoles())
                .updatedAt(LocalDateTime.now())
                .username(employee.getUsername())
                .build();
        return updateResponseDto;
    }


}
