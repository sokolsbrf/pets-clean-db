package ru.dimasokol.school.demosqlite.presenter;

import androidx.annotation.NonNull;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ru.dimasokol.school.demosqlite.model.BusinessException;
import ru.dimasokol.school.demosqlite.model.Pet;
import ru.dimasokol.school.demosqlite.usecase.AddPetInteractor;

public class AddPetPresenter {

    private final AddPetInteractor mInteractor;

    @NonNull
    private AddPetView mView = new AddPetView.Empty();
    private Disposable mDisposable;

    private Pet mPet;
    private BusinessException mException;

    public AddPetPresenter(AddPetInteractor interactor) {
        mInteractor = interactor;
    }

    public void attachView(AddPetView view) {
        mView = view;
        notifyView();
    }

    public void detachView() {
        mView = new AddPetView.Empty();
    }

    public void addPet(String name, String age, int selectedType) {
        int nAge = Integer.valueOf(age);
        Pet.PetType petType = Pet.PetType.values()[selectedType];

        mDisposable = mInteractor.addPet(name, nAge, petType)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Pet>() {
                    @Override
                    public void accept(Pet pet) throws Exception {
                        mPet = pet;
                        notifyView();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (throwable instanceof BusinessException) {
                            mException = (BusinessException) throwable;
                            notifyView();
                        }
                    }
                });
    }

    private void notifyView() {
        if (mException != null) {
            mView.onError(mException.getMessageRes());
            return;
        }

        if (mPet != null) {
            mView.onPetAdded();
        }
    }
}
