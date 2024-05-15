package com.kylych.notesapp.controller;

import com.kylych.notesapp.entity.Note;
import com.kylych.notesapp.entity.User;
import com.kylych.notesapp.service.NoteService;
import com.kylych.notesapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class NoteController {

    private final NoteService noteService;
    private final UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping("/users/{userId}/notes")
    public Note createNote(@PathVariable(value = "userId") Long userId, @Validated @RequestBody Note note) {
        User user = userService.findById(userId);
        return noteService.createNote(note);
    }

    @GetMapping("/users/{userId}/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long userId, Long id){
        return noteService.getNoteById(id);
    }

    @PutMapping("users/{userId}/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long userId, Long id, @Validated @RequestBody Note note){
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/users/{userId}/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }


}
