package com.example.presenceqrcode.controller;

import com.example.presenceqrcode.model.User;
import com.example.presenceqrcode.repository.UserRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/students")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll(){
        return this.userRepository.findAll();
    }
    @GetMapping("/{id}")
    public User getOne(@PathVariable("id") Long id){
        return this.userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createStudent(@RequestBody User user)throws Exception {
        //Using the algorithm to create the base64 qrcode
        int imageSize = 400;
        String img = user.getId().toString();
        BitMatrix matrix = new MultiFormatWriter().encode(img, BarcodeFormat.QR_CODE,
                imageSize, imageSize);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(matrix, "png", bos);

        String image = Base64.getEncoder().encodeToString(bos.toByteArray());

        String src = "data:image/png;base64," + image;
        user.setImg(src);
        return this.userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }


    //FUNCTION TO ASSIGN THE PRESENCE == TRUE
    @PutMapping("/{id}")
    public User truePresence(@PathVariable("id") Long id, @RequestParam(required = true) Boolean presence){
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
        user.setPresence(presence);
        return userRepository.save(user);
    }



}
