package com.example.TS;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {

    private final Map<Long, Note> noteMap = new HashMap<>();

    private long idCounter = 1;

    public List<String> listAll() {
        List<String> allNotesAsString = new ArrayList<>();
        for (Note note : noteMap.values()) {
            allNotesAsString.add(note.toString());
        }
        return allNotesAsString;
    }

    public Note add(Note note) {
        long generatedId = idCounter++;
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

    public void update(Note note) {
        long id = note.getId();
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " not found");
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
