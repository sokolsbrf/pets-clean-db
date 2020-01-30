package ru.dimasokol.school.demosqlite.model;

public class Pet {

    private final long mId;
    private final String mName;
    private final int mAge;
    private final PetType mType;

    public Pet(long id, String name, int age, PetType type) {
        mId = id;
        mName = name;
        mAge = age;
        mType = type;
    }

    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public PetType getType() {
        return mType;
    }

    public enum PetType {
        DOG,
        CAT,
        HAMSTER
    }

}
