package ru.dimasokol.school.demosqlite.repository;

import androidx.annotation.WorkerThread;

import ru.dimasokol.school.demosqlite.model.Pet;

public interface PetsRepository {

    @WorkerThread
    Pet addPet(String name, int age, Pet.PetType type);

}
