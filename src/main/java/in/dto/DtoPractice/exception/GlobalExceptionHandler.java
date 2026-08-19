package in.dto.DtoPractice.exception;

import in.dto.DtoPractice.dto.ExceptionResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto>  handleRunTimeException(RuntimeException e ,
                                                                        HttpServletRequest httpServletRequest){
        ExceptionResponseDto exceptionResponseDto = ExceptionResponseDto.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(e.getMessage())
                .timeStamp(LocalDateTime.now())
                .path(httpServletRequest.getRequestURI())
                .build();
        return ResponseEntity
                . status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponseDto);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleResourceNotFound(ResourceNotFoundException ex ,
                                                                       HttpServletRequest httpServletRequest){
        ExceptionResponseDto exceptionResponseDto = ExceptionResponseDto.builder()
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.NO_CONTENT.value())
                .message(ex.getMessage())
                .error(HttpStatus.NO_CONTENT.getReasonPhrase())
                .path(httpServletRequest.getRequestURI())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponseDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleGenericException(Exception exception ,
                                                                       HttpServletRequest httpServletRequest){
        ExceptionResponseDto exceptionResponseDto = ExceptionResponseDto.builder()
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .message(exception.getMessage())
                .path(httpServletRequest.getRequestURI())
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponseDto);

    }
}
