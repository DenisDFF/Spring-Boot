package com.example.TS.Service;

import com.example.TS.Enity.Note;
import com.example.TS.Service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    Note note = new Note();

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping("/list")
    public String listNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes", notes);
        return "list";
    }

    @RequestMapping("/delete")
    public RedirectView deleteNoteById(@RequestParam long id) {
        noteService.deleteById(id);
        return new RedirectView("/note/list");
    }

    @GetMapping("/edit")
    public String editNotePage(@RequestParam long id, Model model) {
        Note note1 = noteService.getById(id);
        model.addAttribute("note", note1);
        return "edit";
    }

    @PostMapping("/edit")
    public RedirectView editNotes(@ModelAttribute Note updatedNote) {
        noteService.update(updatedNote);
        return new RedirectView("/note/list");
    }

    @RequestMapping("/create")
    public String createNote(Model model) {
        model.addAttribute("note", new Note());
        return "create";
    }

    @PostMapping("/create")
    public String createNoteSubmit(@ModelAttribute Note note, Model model) {
        if (note != null && note.getTitle() != null) {
            Note addedNote = noteService.add(note);
            model.addAttribute("addedNote", addedNote);
            return "redirect:/note/list";
        }
        return "redirect:/note/create";
    }
}
