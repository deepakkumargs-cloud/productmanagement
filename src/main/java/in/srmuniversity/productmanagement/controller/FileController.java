package in.srmuniversity.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import in.srmuniversity.productmanagement.helper.FileUploadHelper;

// Dummay file controller

@RestController
public class FileController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    public String upload(@RequestParam("image") MultipartFile file) {

        try {

            // validation
            if (file.isEmpty()) {
                return "Request Must Contain a File";
            }

            // Content Filtering
            if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/jpg")
                    && !file.getContentType().equals("image/png")) {
                return "Only JPEG, JPG or PNG file format is Allowed";
            }

            // Uploadation Process

            boolean _isFileExists = fileUploadHelper.uploadFile(file);

            if (_isFileExists) {
                return ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/")
                        .path(file.getOriginalFilename()).toString();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Something Went Wrong";
    }
}
