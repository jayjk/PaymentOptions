package com.test.paymentoptions.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Form input element description.
 */
@Getter
@Setter
public class InputElement {
    /** name */
    private String name;
    /** type */
    private String type;
    /** options */
    private List<SelectOption> options;
}