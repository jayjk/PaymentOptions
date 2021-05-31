package com.test.paymentoptions.models;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is designed to hold account mask for registered payment network.
 */
@Getter
@Setter
public class AccountMask {
    /** Simple API, always present */
    private String displayLabel;
    /** Simple API, optional */
    private String holderName;
    /** Simple API, optional */
    private String number;
    /** Simple API, optional */
    private String bankCode;
    /** Simple API, optional */
    private String bankName;
    /** Simple API, optional */
    private String bic;
    /** Simple API, optional */
    private String branch;
    /** Simple API, optional */
    private String city;
    /** Simple API, optional */
    private Integer expiryMonth;
    /** Simple API, optional */
    private Integer expiryYear;
    /** Simple API, optional */
    private String iban;
    /** Simple API, optional */
    private String login;
}