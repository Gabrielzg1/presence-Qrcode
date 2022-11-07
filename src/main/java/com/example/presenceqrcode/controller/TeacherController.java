package com.example.presenceqrcode.controller;

import com.example.presenceqrcode.model.Teacher;
import com.example.presenceqrcode.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public Teacher getOne(@PathVariable("id") String id){
        return this.teacherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not Found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher createTeacher(@RequestBody Teacher teacher)throws Exception {
        return this.teacherRepository.save(teacher);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        teacherRepository.deleteById(id);
    }

}
