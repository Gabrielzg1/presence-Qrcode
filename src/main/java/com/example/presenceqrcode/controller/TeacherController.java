package com.example.presenceqrcode.controller;

import com.example.presenceqrcode.model.Teacher;
import com.example.presenceqrcode.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController  {

    private final TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public List<Teacher> getAll(){
        return this.teacherRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Teacher> getOne(@PathVariable("id") Long id){
        return this.teacherRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher createTeacher(@RequestBody Teacher teacher)throws Exception {
        return this.teacherRepository.save(teacher);
    }
}
