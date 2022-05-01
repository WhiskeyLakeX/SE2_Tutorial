package edu.hanu.mynote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.List;

import edu.hanu.mynote.adapters.NoteAdapter;
import edu.hanu.mynote.db.DbHelper;
import edu.hanu.mynote.db.NoteManager;
import edu.hanu.mynote.models.Note;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // get ref to recycleView
        RecyclerView rvNotes = findViewById(R.id.rvNotes);
        // set layout for items
        rvNotes.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //prepare dataset
        NoteManager noteManager = new NoteManager();
        List<Note> notes = noteManager.all();
        // init adapter
        NoteAdapter noteAdapter = new NoteAdapter(notes);
        //set adapter
        rvNotes.setAdapter(noteAdapter);
    }
}