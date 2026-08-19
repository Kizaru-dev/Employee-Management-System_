package in.dto.DtoPractice.dto;

import in.dto.DtoPractice.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResponseDto {
    private Long id ;

    private String name ;
    private String username ;
    private String fatherName ;
    private Roles roles ;
    private String phoneNo;
    private String email ;
    private LocalDateTime updatedAt;
}
