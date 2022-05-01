package edu.hanu.mynote.db;

import java.util.ArrayList;
import java.util.List;

import edu.hanu.mynote.models.Note;

public class NoteManager {
    public List<Note> all() {
        List<Note> notes = new ArrayList<>();
        notes.add(new Note("Temp Note 1"));
        notes.add(new Note("Temp Note 2"));
        notes.add(new Note("Temp Note 3"));

        return notes;
    }
}
