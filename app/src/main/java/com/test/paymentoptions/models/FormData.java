package com.test.paymentoptions.models;

import java.net.URL;

import lombok.Getter;
import lombok.Setter;

/**
 * Form data to pre-fill network form. Not all data could be provided- it depends what data we know already and what network should been used.
 */
@Getter
@Setter
public class FormData {
    /** account-related data to pre-fill a form */
    private AccountFormData account;
    /** customer-related data to pre-fill a form */
    private CustomerFormData customer;
    /** installments plans data */
    private Installments installments;
    /** An URL to the data privacy consent document */
    private URL dataPrivacyConsentUrl;
}