package model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.servlet.http.Part;

public class FileUpload {

    private static final String UPLOAD_DIR = "uploads";

    public String uploadFile(Part part, String uploadPath) throws IOException {
    	
        String fileName = getFileName(part);
        if (fileName != null && !fileName.isEmpty()) {
            String filePath = uploadPath + File.separator + fileName;
            try (InputStream inputStream = part.getInputStream()) {
                Files.copy(inputStream, Paths.get(filePath));
            }
            return fileName;
        }
        return null;
    }

    private String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
