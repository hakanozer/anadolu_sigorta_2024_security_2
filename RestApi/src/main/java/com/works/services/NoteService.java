package com.works.services;

import com.works.entities.Note;
import com.works.entities.Product;
import com.works.repositories.NoteRepository;
import com.works.utils.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    final NoteRepository noteRepository;

    public ResponseEntity save(Note note) {
        noteRepository.save(note);
        return Rest.success(note);
    }

    public ResponseEntity list() {
        List<Note> noteList = noteRepository.findAll();
        return Rest.success(noteList);
    }

}
