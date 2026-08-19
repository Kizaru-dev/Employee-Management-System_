package in.dto.DtoPractice.dto;

import in.dto.DtoPractice.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {
    private String name ;
    private String username ;
    private String fatherName ;
    private Roles roles ;
    private String phoneNo;
    private String email ;
}
