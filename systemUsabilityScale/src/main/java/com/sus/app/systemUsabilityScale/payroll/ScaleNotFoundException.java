package com.sus.app.systemUsabilityScale.payroll;

public class ScaleNotFoundException extends RuntimeException{

    public ScaleNotFoundException(Long id) {
        super("Could not find scale " + id);
    }
}
