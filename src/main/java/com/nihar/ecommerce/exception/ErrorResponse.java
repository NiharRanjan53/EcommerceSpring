package com.nihar.ecommerce.exception;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timeStamp;
    public ErrorResponse(int status, String message, LocalDateTime timeStamp){
        this.status= status;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
