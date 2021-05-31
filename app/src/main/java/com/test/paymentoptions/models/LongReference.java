package com.test.paymentoptions.models;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is designed to hold advanced reference information about payment.
 */
@Getter
@Setter
public class LongReference {
    /** mandatory (max 32) */
    private String essential;
    /** optional (max 32) */
    private String extended;
    /** optional (max 32) */
    private String verbose;
}