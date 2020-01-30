package ru.dimasokol.school.demosqlite.usecase;

import ru.dimasokol.school.demosqlite.model.BusinessException;

public class Result<T> {

    private T mData;
    private BusinessException mException;

    private OnComplete<T> mComplete;
    private OnError mError;

    public void subscribe(OnComplete<T> complete, OnError error) {
        mComplete = complete;
        mError = error;
        notifyListeners();
    }

    void complete(T data) {
        mData = data;
        notifyListeners();
    }

    void error(BusinessException e) {
        mException = e;
        notifyListeners();
    }

    private void notifyListeners() {
        if (mException != null && mError != null) {
            mError.onError(mException);
        }

        if (mData != null && mComplete != null) {
            mComplete.onComplete(mData);
        }
    }

    public interface OnComplete<T> {
        void onComplete(T data);
    }

    public interface OnError {
        void onError(BusinessException exception);
    }
}
