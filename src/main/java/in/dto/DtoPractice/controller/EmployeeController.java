package in.dto.DtoPractice.controller;

import in.dto.DtoPractice.dto.EmployeeRequestDto;
import in.dto.DtoPractice.dto.EmployeeResponseDto;
import in.dto.DtoPractice.dto.UpdateRequestDto;
import in.dto.DtoPractice.dto.UpdateResponseDto;
import in.dto.DtoPractice.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService ;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeRequestDto requestDto){
        return ResponseEntity.ok(employeeService.createEmployee(requestDto));
    }

    @GetMapping("/id")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@RequestParam Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployee(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PatchMapping("id")
    public ResponseEntity<String> softDeleteEmployee(@RequestParam Long id){
        return ResponseEntity.ok("Employee has been Deleted Successfully");
    }

    @PutMapping("id")
    public ResponseEntity<UpdateResponseDto> updateEmployeeById(@RequestBody UpdateRequestDto updateRequestDto , @RequestParam Long id){
        return ResponseEntity.ok(employeeService.updateEmployee(updateRequestDto,id));
    }

    @DeleteMapping("id")
    public ResponseEntity<String> deleteEmployeeById(@RequestParam Long id){
        return ResponseEntity.ok("Employee has been Deleted Permanently");
    }
}
