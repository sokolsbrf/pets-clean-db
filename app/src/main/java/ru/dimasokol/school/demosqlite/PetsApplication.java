package ru.dimasokol.school.demosqlite;

import android.app.Application;
import android.os.StrictMode;

import ru.dimasokol.school.demosqlite.presenter.AddPetPresenter;
import ru.dimasokol.school.demosqlite.repository.PetsRepository;
import ru.dimasokol.school.demosqlite.repository.PetsRepositoryImpl;
import ru.dimasokol.school.demosqlite.usecase.AddPetInteractorImpl;

public class PetsApplication extends Application {

    private AddPetPresenter mAddPetPresenter;
    private PetsRepository mPetsRepository;

    public AddPetPresenter getAddPetPresenter() {
        return mAddPetPresenter;
    }

    public AddPetPresenter createAddPetPresenter() {
        mAddPetPresenter = new AddPetPresenter(new AddPetInteractorImpl(mPetsRepository));
        return mAddPetPresenter;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPetsRepository = new PetsRepositoryImpl(this);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyDialog()
                .build());
    }
}
