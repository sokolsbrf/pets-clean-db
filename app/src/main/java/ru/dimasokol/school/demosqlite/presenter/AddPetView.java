package ru.dimasokol.school.demosqlite.presenter;

import androidx.annotation.StringRes;

public interface AddPetView {

    void onPetAdded();
    void onError(@StringRes int errorRes);

    class Empty implements AddPetView {
        @Override
        public void onPetAdded() {
        }

        @Override
        public void onError(int errorRes) {
        }
    }
}
