package ru.dimasokol.school.demosqlite.model;

import androidx.annotation.StringRes;

public class BusinessException extends Exception {

    @StringRes
    private final int mMessageRes;

    public BusinessException(int messageRes) {
        mMessageRes = messageRes;
    }

    public int getMessageRes() {
        return mMessageRes;
    }
}
