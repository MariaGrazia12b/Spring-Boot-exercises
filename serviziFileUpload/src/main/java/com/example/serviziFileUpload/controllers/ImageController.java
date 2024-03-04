package com.example.serviziFileUpload.controllers;

import com.example.serviziFileUpload.services.FileService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ImageController {

    @Autowired
    private final FileService fileService;

    @GetMapping("/image/{id}")
    @ResponseBody
    public byte[] downloadPhoto(@PathVariable String name,
                                HttpServletResponse response) throws IOException
    {
        String extension = FilenameUtils.getExtension(name);
        switch (extension) {
            case "gif":
                response.setContentType(MediaType.IMAGE_GIF_VALUE);
                break;
            case "jpg":
            case "jpeg":
                response.setContentType(MediaType.IMAGE_JPEG_VALUE);
                break;
            case "png":
                response.setContentType(MediaType.IMAGE_PNG_VALUE);
                break;
        }
        response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
        return fileService.download(name);
    }

    @PostMapping("/image")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        return fileService.upload(file);
    }


}
