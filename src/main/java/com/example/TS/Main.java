package com.example.TS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

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
