package com.test.paymentoptions.models;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.StringDef;

/**
 * This class describes HTTP methods that are valid for customer's browser redirect.
 */
public class HttpMethod {

    public final static String GET = "GET";
    public final static String POST = "POST";

    /**
     * Check if the given method is a valid http method
     *
     * @param method the http method to validate
     * @return true when valid, false otherwise
     */
    public static boolean isValid(final String method) {

        if (method != null) {
            switch (method) {
                case GET:
                case POST:
                    return true;
            }
        }
        return false;
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
        GET,
        POST })
    public @interface Definition { }
}