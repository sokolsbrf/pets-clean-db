package ru.dimasokol.school.demosqlite.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.WorkerThread;

import ru.dimasokol.school.demosqlite.db.PetsDatabase;
import ru.dimasokol.school.demosqlite.db.PetsModel;
import ru.dimasokol.school.demosqlite.model.Pet;

public class PetsRepositoryImpl implements PetsRepository {

    private Context mContext;
    private PetsDatabase mHelper;

    public PetsRepositoryImpl(Context context) {
        mContext = context;
    }

    @Override
    @WorkerThread
    public Pet addPet(String name, int age, Pet.PetType type) {
        if (mHelper == null) {
            mHelper = new PetsDatabase(mContext);
        }

        SQLiteDatabase db = mHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PetsModel.Columns.NAME, name);
        cv.put(PetsModel.Columns.AGE, age);
        cv.put(PetsModel.Columns.TYPE, type.ordinal());

        long id = db.insert(PetsModel.TABLE_NAME, null, cv);
        db.close();

        return new Pet(id, name, age, type);
    }
}
