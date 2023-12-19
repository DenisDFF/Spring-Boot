package com.example.TS;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {

//    private final Map<Long, Note> noteMap = new HashMap<>();

    private final NoteRepository repository;
    private final AtomicLong idCounter = new AtomicLong();

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public List<Note> listAll() {
        return repository.findAll();
    }

    public Note add(Note note) {
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        return repository.save(note);
    }


    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public void update(Note note) {
        note.setUpdatedAt(LocalDateTime.now());
        repository.save(note);
    }

    public Note getById(long id) {
        return repository.findById(id).orElse(null);
    }
}
