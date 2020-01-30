package ru.dimasokol.school.demosqlite.db;

public final class PetsModel {

    public static final String TABLE_NAME = "pets";

    public static final class Columns {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String AGE = "age";
        public static final String TYPE = "type";

        public static final String[] ALL = new String[] {
                ID, NAME, AGE, TYPE
        };
    }

}
