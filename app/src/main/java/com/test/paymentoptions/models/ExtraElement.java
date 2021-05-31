package com.test.paymentoptions.models;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is designed to hold information about extra element that is displayed on payment page.
 */
@Getter
@Setter
public class ExtraElement {
    /** Advanced API, optional */
    private String text;
    /** Advanced API, optional */
    private Checkbox checkbox;
}