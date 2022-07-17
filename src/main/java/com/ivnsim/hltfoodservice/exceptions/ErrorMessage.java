package com.ivnsim.hltfoodservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
public class ErrorMessage {
    private Timestamp timestamp;
    private Integer status;
    private String message;
    private String path;
}
