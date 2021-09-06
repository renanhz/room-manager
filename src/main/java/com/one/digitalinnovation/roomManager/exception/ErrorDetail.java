package com.one.digitalinnovation.roomManager.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetail {
    private Date timestamp;
    private String message;
    private String details;
}
