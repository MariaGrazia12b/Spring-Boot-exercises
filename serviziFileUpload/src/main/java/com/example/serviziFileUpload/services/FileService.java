package com.example.serviziFileUpload.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileService {

    @Value("${uploadDir}")
    private String fileFolder;

    public String upload(MultipartFile file) throws IOException {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString();
        String completeFileName = newFileName + "." + extension;

        File finalFolder = new File(fileFolder);
        if (!finalFolder.exists()) throw new IOException("Final folder does not exists");
        if (!finalFolder.isDirectory()) throw new IOException("Final folder is not a directory");

        File finalDestination = new File(fileFolder + "\\" + completeFileName);
        if (finalDestination.exists()) throw new IOException("File conflict");

        file.transferTo(finalDestination);
        return completeFileName;
    }
        public byte[] download(String fileName) throws IOException
        {
            File fileFromRepository = new File(fileFolder+"\\"+fileName);
            if(!fileFromRepository.exists()) throw new IOException("File doesn't exist.");
            return IOUtils.toByteArray(new FileInputStream(fileFromRepository));

        }

    }
