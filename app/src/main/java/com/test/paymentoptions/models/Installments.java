package com.test.paymentoptions.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Installments information.
 */
@Getter
@Setter
public class Installments {
    /** payment amount of original payment */
    private PaymentAmount originalPayment;
    /** installments plans */
    private List<InstallmentsPlan> plans;
}