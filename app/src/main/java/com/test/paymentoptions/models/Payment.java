package com.test.paymentoptions.models;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is designed to hold payment information.
 */
@Getter
@Setter
public class Payment {
    /** mandatory */
    private String reference;
    /** mandatory */
    private BigDecimal amount;
    /** mandatory */
    private String currency;
    /** optional (max 128) */
    private String invoiceId;
    /** optional */
    private LongReference longReference;
}