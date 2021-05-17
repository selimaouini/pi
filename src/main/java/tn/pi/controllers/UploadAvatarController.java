package tn.pi.controllers;

import tn.pi.exception.StorageFileNotFoundException;
import tn.pi.entities.User;
import tn.pi.services.StorageService;
//import tn.pi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UploadAvatarController {

    private final StorageService storageService;

    @Autowired
    public UploadAvatarController(StorageService storageService) {
        this.storageService = storageService;
    }

   

    @PostMapping("/upload-avatar")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
       
        if (storageService.isCorrectImageType(file)) {
            storageService.store(file);
            return "redirect:/upload-avatar?success";
        } else {
            return "redirect:/upload-avatar?wrongtype";
        }
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}