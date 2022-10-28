package com.example.presenceqrcode.controller;

import com.example.presenceqrcode.model.Student;
import com.example.presenceqrcode.repository.StudentRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController  {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getAll(){
        return this.studentRepository.findAll();
    }
    @GetMapping("/{id}")
    public Student getOne(@PathVariable("id") Long id){
        return this.studentRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student)throws Exception {
        //Using the algorithm to create the base64 qrcode
        int imageSize = 400;
        String img = student.getId().toString();
        BitMatrix matrix = new MultiFormatWriter().encode(img, BarcodeFormat.QR_CODE,
                imageSize, imageSize);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(matrix, "png", bos);

        String image = Base64.getEncoder().encodeToString(bos.toByteArray());

        String src = "data:image/png;base64," + image;
        student.setImg(src);
        return this.studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
    }

    @PutMapping()
    public Student update(@RequestBody Student student){
        return studentRepository.save(student);
    }
}
