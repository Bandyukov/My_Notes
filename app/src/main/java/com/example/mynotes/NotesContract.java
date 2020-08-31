package com.example.mynotes;

import android.provider.BaseColumns;

public class NotesContract {
    public static final class NotesEntry implements BaseColumns {
        public static final String TABLE_NAME = "notes", COLUMN_TITLE = "title",
                COLUMN_DESCRIPTION = "description", COLUMN_DAY_OF_WEEK = "day_of_week", COLUMN_PRIORITY = "priority",
                TYPE_TEXT = "TEXT", TYPE_INTEGER = "INTEGER";

        public static final String CREATE_COMMAND = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + _ID + " " +
                        TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " + COLUMN_TITLE + " " + TYPE_TEXT + ", " +
                        COLUMN_DESCRIPTION + " " + TYPE_TEXT + ", " + COLUMN_DAY_OF_WEEK + " " + TYPE_TEXT + ", " +
                        COLUMN_PRIORITY + " " + TYPE_INTEGER + ")";

        public static final String DROP_COMMAND = "DROP TABLE IF EXISTS " + TABLE_NAME;



    }
}
