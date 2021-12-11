package com.api.book.springbootrestapi.Controller;

import javax.servlet.Servlet;

import com.api.book.springbootrestapi.Helper.FileUploadHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        /*
         * System.out.println(file.getOriginalFilename());
         * System.out.println(file.getContentType());
         * System.out.println(file.getSize());
         * System.out.println(file.getBytes());
         * System.out.println(file.getInputStream());
         * System.out.println(file.getName());
         */

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please select file");
        }
        if (file.getContentType().equals("Image/jpg")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Select only jpg file");
        }

        boolean f = fileUploadHelper.uploadFile(file);
        if (f) {
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/Image/")
                    .path(file.getOriginalFilename()).toUriString());
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File not uploaded");

    }

}
