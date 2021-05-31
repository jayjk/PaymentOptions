package com.test.paymentoptions.models;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * Payment amount data.
 */
@Getter
@Setter
public class PaymentAmount {
    /** amount */
    private BigDecimal amount;
    /** currency */
    private String currency;
}