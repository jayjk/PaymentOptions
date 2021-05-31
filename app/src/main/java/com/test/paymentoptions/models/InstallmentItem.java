package com.test.paymentoptions.models;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * An information about particular payment what is involved into installment payment process.
 */
@Getter
@Setter
public class InstallmentItem {
    /** The amount of installment (mandatory) */
    private BigDecimal amount;
    /** Installment/payment date */
    private Date date;
}