package com.nikkhat.blog.controller;

import com.nikkhat.blog.config.CloudinaryImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ImageController {

    @Autowired
    private CloudinaryImageService imageService;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        return imageService.uploadImage(file);
    }
}

