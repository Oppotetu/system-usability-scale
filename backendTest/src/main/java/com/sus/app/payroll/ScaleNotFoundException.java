package com.sus.app.payroll;

public class ScaleNotFoundException extends RuntimeException{

    public ScaleNotFoundException(Long id) {
        super("Could not find scale " + id);
    }
}
