package com.test.paymentoptions.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is designed to hold information about extra elements that should be displayed on payment page.
 */
@Getter
@Setter
public class ExtraElements {
    private List<ExtraElement> top;
    private List<ExtraElement> bottom;
}