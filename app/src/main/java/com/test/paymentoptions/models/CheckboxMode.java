package com.test.paymentoptions.models;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.StringDef;

/**
 * This class describes possible checkbox display modes.
 */
public class CheckboxMode {

    public final static String OPTIONAL = "OPTIONAL";
    public final static String OPTIONAL_PRESELECTED = "OPTIONAL_PRESELECTED";
    public final static String REQUIRED = "REQUIRED";
    public final static String REQUIRED_PRESELECTED = "REQUIRED_PRESELECTED";
    public final static String FORCED = "FORCED";
    public final static String FORCED_DISPLAYED = "FORCED_DISPLAYED";

    /**
     * Check if the given mode is a valid checkbox mode
     *
     * @param mode the checkbox mode to validate
     * @return true when valid, false otherwise
     */
    public static boolean isValid(final String mode) {

        if (mode != null) {
            switch (mode) {
                case OPTIONAL:
                case OPTIONAL_PRESELECTED:
                case REQUIRED:
                case REQUIRED_PRESELECTED:
                case FORCED:
                case FORCED_DISPLAYED:
                    return true;
            }
        }
        return false;
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
        OPTIONAL,
        OPTIONAL_PRESELECTED,
        REQUIRED,
        REQUIRED_PRESELECTED,
        FORCED,
        FORCED_DISPLAYED })
    public @interface Definition { }
}