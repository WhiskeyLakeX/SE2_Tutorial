package edu.hanu.mynote.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "notes.db";
    private static final int DB_VERSION = 1;
    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // create tables
        sqLiteDatabase.execSQL("CREATE TABLE notes (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "content TEXT NOT NULL)");

        //demo
        sqLiteDatabase.execSQL("INSERT INTO notes (id, content) VALUES (1, 'EXAMPLE A')");
        sqLiteDatabase.execSQL("INSERT INTO notes (id, content) VALUES (2, 'EXAMPLE B')");
        sqLiteDatabase.execSQL("INSERT INTO notes (id, content) VALUES (3, 'EXAMPLE C')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //drop table - warning lost data
        sqLiteDatabase.execSQL("DROP TABLE notes");
        //create again
        onCreate(sqLiteDatabase);
    }
}
