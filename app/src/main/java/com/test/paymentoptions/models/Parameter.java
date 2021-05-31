package com.test.paymentoptions.models;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is designed to hold information about HTTP parameter.
 */
@Getter
@Setter
public class Parameter {
    /** Simple API, always present */
    private String name;
    /** Simple API, optional */
    private String value;
}