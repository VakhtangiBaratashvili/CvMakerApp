package com.example.cvmaker.service;

import com.example.cvmaker.dto.ApiSuccessResponse;
import com.example.cvmaker.meta.Education;
import com.example.cvmaker.meta.Experience;
import com.example.cvmaker.model.Cv;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CvService {

    ResponseEntity<ApiSuccessResponse> addCv(Cv cv);

    ResponseEntity<ApiSuccessResponse> addManyCvs(List<Cv> cvs);

    ResponseEntity<ApiSuccessResponse> addSocial(String id, String social, String link);

    ResponseEntity<ApiSuccessResponse> addSkill(String id, String skill);

    ResponseEntity<ApiSuccessResponse> addExperience(String id, Experience experience);

    ResponseEntity<ApiSuccessResponse> addEducation(String id, Education education);

    ResponseEntity<ApiSuccessResponse> addLanguage(String id, String language, String level);

    ResponseEntity<ApiSuccessResponse> getAllCvs();

    ResponseEntity<ApiSuccessResponse> getCvById(String id);

    ResponseEntity<ApiSuccessResponse> updateFullName(String id, String fullName);

    ResponseEntity<ApiSuccessResponse> updateAboutMe(String id, String aboutMe);

    ResponseEntity<ApiSuccessResponse> updateCvById(String id, Cv cv);

    ResponseEntity<ApiSuccessResponse> deleteCvById(String id);

    ResponseEntity<ApiSuccessResponse> deleteAllCvs();
}
