package com.my.util;

public enum SortUtil {
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    EMAIL("email");

    private final String sort;
    SortUtil(String sort) {
        this.sort = sort;
    }

    public String getSortingField() {
        return sort;
    }
}
