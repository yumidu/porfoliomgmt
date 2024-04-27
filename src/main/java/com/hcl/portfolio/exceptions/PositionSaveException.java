package com.hcl.portfolio.exceptions;

/**
 *
 * @author Yumidu Jayarathna
 * @since 4/27/2024
 */

public class PositionSaveException extends RuntimeException {
    public PositionSaveException(String message) {
        super(message);
    }
}
