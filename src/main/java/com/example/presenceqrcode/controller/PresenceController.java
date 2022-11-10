package com.example.presenceqrcode.controller;

import com.example.presenceqrcode.model.Presence;
import com.example.presenceqrcode.repository.PresenceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/presence")
public class PresenceController {
    private final PresenceRepository presenceRepository;

    public PresenceController(PresenceRepository presenceRepository){

        this.presenceRepository = presenceRepository;
    }

    @GetMapping
    public List<Presence> getAll(){
        return this.presenceRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Presence createStudent(@RequestBody Presence presence)throws Exception {
        LocalDate date = LocalDate.now();
        presence.setDate(date);
        return this.presenceRepository.save(presence);
    }

    @GetMapping("/{id}")
    public Presence getOne(@PathVariable("id") String id){
        return this.presenceRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Presence not found!"));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id) {
        presenceRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Presence truePresence(@PathVariable("id") String id, @RequestParam(required = true) Long newRa){
        Presence presence = presenceRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found!"));

        if(!presence.getPresenceList().contains(newRa)){
            presence.getPresenceList().add(newRa);
            return presenceRepository.save(presence);
        } else {
            throw new RuntimeException("Ra already in the attendance");
        }
    }



}
