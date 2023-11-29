package com.example.TS;

import java.util.List;

public class Main {
    public static void main(String[] args) {

            NoteService noteService = new NoteService();

            Note note = new Note();
            note.setTitle("Note1");
            note.setContent("cook the chicken");

            Note addedNote = noteService.add(note);
            System.out.println("Added Note Name: " + addedNote.getTitle().toString());
            System.out.println("Added Note Content: " + addedNote.getContent().toString());

            List<String> allNote = noteService.listAll();
        System.out.println(allNote);
    }
}
