package com.FileUpload.controller;

import com.FileUpload.entity.YourEntity;
import com.FileUpload.service.YourEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/institutes")

public class YourEntityController {
    @Autowired
    private  YourEntityService yourEntityService;

    @PostMapping("/saveData")
    public ResponseEntity<String> createYourEntity(
            @RequestParam("authorizedPersonName") String authorizedPersonName,
            @RequestParam("mobileNumber") long mobileNumber,
            @RequestParam("adharNumber") Long adharNumber,
            @RequestParam("aadharFront") MultipartFile aadharFront,
            @RequestParam("aadharBack") MultipartFile aadharBack,
            @RequestParam("instituteType") String instituteType,
            @RequestParam("instituteName") String instituteName,
            @RequestParam("instituteContactNumber") Long instituteContactNumber,
            @RequestParam("instituteEmailId") String instituteEmailId,
            @RequestParam("instituteRegistrationNumber") String instituteRegistrationNumber,
            @RequestParam("governmentLicenseCopy") MultipartFile governmentLicenseCopy,
            @RequestParam("password") String password,
            @RequestParam("securityPin") int securityPin,
            @RequestParam("location") String location,
            @RequestParam("state") String state,
            @RequestParam("district") String district,
            @RequestParam("status") String status,
            @RequestParam("date") Date registerDate) throws IOException {

            String a1=savePhoto(aadharFront);
            String a2=savePhoto(aadharBack);
            String l1=savePhoto(governmentLicenseCopy);


        try {
            YourEntity savedEntity = yourEntityService.saveEntity(authorizedPersonName, mobileNumber, adharNumber,
                    a1, a2, instituteType, instituteName, instituteContactNumber, instituteEmailId,
                    instituteRegistrationNumber, l1, password, securityPin, location, state, district,status,registerDate);

            return ResponseEntity.ok("Entity created successfully with ID: " + savedEntity.getId());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating entity: " + e.getMessage());
        }


    }
    private String savePhoto(MultipartFile photo) throws IOException {
        // Implement your logic to save the photo and return the URL
        // For simplicity, let's assume we save it to a local folder and return the path
        // You may want to use a proper storage service like Amazon S3 in a real application
        String filePath = "C:\\Users\\diras\\OneDrive\\Documents\\" + photo.getOriginalFilename();
        photo.transferTo(new File(filePath));
        return filePath;
    }
    @GetMapping("/getAll")
    public List<YourEntity> getAll(){
        List<YourEntity> list=  yourEntityService.getAll();
        return list;

    }
}
