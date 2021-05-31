package com.test.paymentoptions.repositories.data;

import com.test.paymentoptions.models.ListResult;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

    private Integer responseCode;
    private String msg;
    private ListResult listResult;

}
