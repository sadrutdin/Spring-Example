package com.zaynukov.dev.service;

public final class ApplicationUtils {
    private ApplicationUtils() {
        throw new RuntimeException("Can't create instance of " + getClass().getPackage().getName()
                + '.' + getClass().getSimpleName());
    }
}
