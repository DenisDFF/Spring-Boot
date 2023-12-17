package com.example.TS;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {

    private final Map<Long, Note> noteMap = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

//    private long idCounter = 1;

//    public List<Note> listAll() {
//        List<Note> allNotesAsString = new ArrayList<>();
//        for (Note note : noteMap.values()) {
//            allNotesAsString.add(note);
//        }
//        return allNotesAsString;
//    }

//    public Note add(Note note) {
//        long generatedId = idCounter++;
//        note.setId(generatedId);
//        noteMap.put(generatedId, note);
//        return note;
//    }

    public List<Note> listAll() {
        return new ArrayList<>(noteMap.values());
    }

    public Note add(Note note) {
        long generatedId = idCounter.incrementAndGet();
        note.setId(generatedId);
        noteMap.put(generatedId, note);
        return note;
    }

    public void deleteById(long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
        noteMap.remove(id);
    }

//    public void update(Note note) {
//        long id = note.getId();
//        if (!noteMap.containsKey(id)) {
//            throw new IllegalArgumentException("Note with id " + id + " not found");
//        }
//        noteMap.put(id, note);
//    }

    public void update(Note note) {
        Long id = note.getId();
        if (id == null || !noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Invalid note or note with id " + id + " not found");
        }
        noteMap.put(id, note);
    }

    public Note getById(long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " not found");
        }
        return noteMap.get(id);
    }
}
