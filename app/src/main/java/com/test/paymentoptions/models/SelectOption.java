package com.test.paymentoptions.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Option description.
 */
@Getter
@Setter
public class SelectOption {
    /** value */
    private String value;
    /** a flag for the option to be preselected - shown first in the drop-down list */
    private Boolean selected;
}