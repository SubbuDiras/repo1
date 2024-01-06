package com.FileUpload.service;

import com.FileUpload.entity.YourEntity;
import com.FileUpload.repository.YouEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class YourEntityService {
@Autowired
private YouEntityRepository yourEntityRepository;
    public YourEntity saveEntity(String authorizedPersonName,
                                 long mobileNumber,
                                 Long adharNumber,
                                 String aadharFront,
                                 String aadharBack,
                                 String instituteType,
                                 String instituteName,
                                 Long instituteContactNumber,
                                 String instituteEmailId,
                                 String instituteRegistrationNumber,
                                 String governmentLicenseCopy,
                                 String password, int securityPin,
                                 String location, String state, String district,
                                 String status, Date registerDate) throws IOException {

        YourEntity entity = new YourEntity();
        entity.setAuthorizedPersonName(authorizedPersonName);
        entity.setMobileNumber(mobileNumber);
        entity.setAdharNumber(adharNumber);
        entity.setAadharFront(aadharFront);
        entity.setAadharBack(aadharBack);
        entity.setInstituteType(instituteType);
        entity.setInstituteName(instituteName);
        entity.setInstituteContactNumber(instituteContactNumber);
        entity.setInstituteEmailId(instituteEmailId);
        entity.setInstituteRegistrationNumber(instituteRegistrationNumber);
        entity.setGovernmentLicenseCopy(governmentLicenseCopy);
        entity.setPassword(password);
        entity.setSecurityPin(securityPin);
        entity.setLocation(location);
        entity.setState(state);
        entity.setDistrict(district);
        entity.setStatus(status);
        entity.setRegisterDate(registerDate);

        return yourEntityRepository.save(entity);
    }

    public List<YourEntity> getAll(){
        return yourEntityRepository.findAll();
    }
    }

