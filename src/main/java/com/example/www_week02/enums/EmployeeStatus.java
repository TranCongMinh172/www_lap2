package com.example.www_week02.enums;

public enum EmployeeStatus {
    WORKING(1),
    HALT(0),
    RESIGN(-1);

    private final  int status;

    EmployeeStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
