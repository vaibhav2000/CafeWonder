package com.cafe.CafeWonder.util.fileutils;

import org.springframework.web.multipart.MultipartFile;

public interface IFileProcessor {
    public void saveFile(MultipartFile file);
}
