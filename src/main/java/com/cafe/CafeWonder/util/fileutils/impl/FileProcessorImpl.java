package com.cafe.CafeWonder.util.fileutils.impl;

import com.cafe.CafeWonder.util.fileutils.IFileProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Component
public class FileProcessorImpl implements IFileProcessor {
    private String imageDirectory = "src/main/resources/static/images/";
    @Override
    public void saveFile(MultipartFile file) {

        try (FileOutputStream fos = new FileOutputStream(imageDirectory + file.getOriginalFilename())) {
            fos.write(file.getBytes());
         }
        catch (Exception e){
        }
    }
}
