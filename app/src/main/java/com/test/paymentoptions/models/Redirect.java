package com.test.paymentoptions.models;

import java.net.URL;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is designed to hold information to redirect customers browser as a result of operation execution.
 */
@Getter
@Setter
public class Redirect {
    /** Simple API, always present */
    private URL url;
    /** Simple API, always present */
    @HttpMethod.Definition
    private String method;
    /** Simple API, optional */
    private List<Parameter> parameters;
    /** Simple API, optional */
    private Boolean suppressIFrame;
    /** Simple API, always present in new transactions */
    private String type;
}