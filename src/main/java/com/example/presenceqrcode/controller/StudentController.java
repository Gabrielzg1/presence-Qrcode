package com.example.presenceqrcode.controller;

import com.example.presenceqrcode.model.Student;
import com.example.presenceqrcode.repository.StudentRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    public Optional<Student> getOne(@PathVariable("id") Long id){
        return this.studentRepository.findById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student)throws Exception {
        int imageSize = 200;
        BitMatrix matrix = new MultiFormatWriter().encode(student.getRa(), BarcodeFormat.QR_CODE,
                imageSize, imageSize);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "png", bos);
        String image = Base64.getEncoder().encodeToString(bos.toByteArray());
        String src = "data:image/png;base64," + image;
        student.setImg(src);
        return this.studentRepository.save(student);


    }
}
