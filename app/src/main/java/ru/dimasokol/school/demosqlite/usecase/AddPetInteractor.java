package ru.dimasokol.school.demosqlite.usecase;

import io.reactivex.Single;
import ru.dimasokol.school.demosqlite.model.Pet;

public interface AddPetInteractor {

    Single<Pet> addPet(String name, int age, Pet.PetType type);

}
