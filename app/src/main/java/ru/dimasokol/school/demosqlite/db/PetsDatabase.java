package ru.dimasokol.school.demosqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import ru.dimasokol.school.demosqlite.R;

public class PetsDatabase extends SQLiteOpenHelper {

    private static final String DB_FILE_NAME = "pets.db";
    private static final int DB_VERSION = 1;

    private String mCreateV1Pets;

    public PetsDatabase(@Nullable Context context) {
        super(context, DB_FILE_NAME, null, DB_VERSION);

        mCreateV1Pets = context.getString(R.string.pets_v1_create);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(mCreateV1Pets);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
