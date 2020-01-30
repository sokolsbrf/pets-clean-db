package ru.dimasokol.school.demosqlite.usecase;

import java.util.concurrent.Callable;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import ru.dimasokol.school.demosqlite.R;
import ru.dimasokol.school.demosqlite.model.BusinessException;
import ru.dimasokol.school.demosqlite.model.Pet;
import ru.dimasokol.school.demosqlite.repository.PetsRepository;

public class AddPetInteractorImpl implements AddPetInteractor {

    private final PetsRepository mRepository;

    public AddPetInteractorImpl(PetsRepository repository) {
        mRepository = repository;
    }

    @Override
    public Single<Pet> addPet(final String name, final int age, final Pet.PetType type) {
        Single<Pet> result = Single.fromCallable(new Callable<Pet>() {
            @Override
            public Pet call() throws Exception {
                if (age >= 30) {
                    throw new BusinessException(R.string.error_bad_age);
                }

                Pet pet = mRepository.addPet(name, age, type);
                return pet;
            }
        }).subscribeOn(Schedulers.io());

        return result;
    }
}
