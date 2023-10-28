package com.user.bill.userbill.helpers.Http.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class ResponseDTO<T> implements Serializable {
    private T data;
    private Integer code;
    private boolean success;
    private String message;
    private List<String> errors;
}
