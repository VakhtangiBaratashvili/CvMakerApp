package com.example.cvmaker.controller;


import com.example.cvmaker.dto.ApiSuccessResponse;
import com.example.cvmaker.meta.Education;
import com.example.cvmaker.meta.Experience;
import com.example.cvmaker.model.Cv;
import com.example.cvmaker.service.CvService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cv")
@AllArgsConstructor
public class CvController {

    private final CvService service;

    @PostMapping("/add-one")
    public ResponseEntity<ApiSuccessResponse> addOneCv(@RequestBody Cv cv) {
        return service.addCv(cv);
    }

    @PostMapping("/add-many")
    public ResponseEntity<ApiSuccessResponse> addManyCv(@RequestBody List<Cv> cvs) {
        return service.addManyCvs(cvs);
    }

    @PostMapping("/add/social/{id}")
    public ResponseEntity<ApiSuccessResponse> addSocial(@PathVariable String id,
                                                        @PathParam("social") String social,
                                                        @PathParam("link") String link) {
        return service.addSocial(id, social, link);
    }

    @PostMapping("/add/skill/{id}")
    public ResponseEntity<ApiSuccessResponse> addSkill(@PathVariable String id,
                                                       @PathParam("skill") String skill) {
        return service.addSkill(id, skill);
    }

    @PostMapping("/add/experience/{id}")
    public ResponseEntity<ApiSuccessResponse> addExperience(@PathVariable String id,
                                                            @RequestBody Experience experience) {
        return service.addExperience(id, experience);
    }

    @PostMapping("/add/education/{id}")
    public ResponseEntity<ApiSuccessResponse> addEducation(@PathVariable String id,
                                                           @RequestBody Education education) {
        return service.addEducation(id, education);
    }

    @PostMapping("/add/language/{id}")
    public ResponseEntity<ApiSuccessResponse> addLanguage(@PathVariable String id,
                                                          @PathParam("language") String language,
                                                          @PathParam("level") String level) {
        return service.addLanguage(id, language, level);
    }

    @GetMapping
    public ResponseEntity<ApiSuccessResponse> getAllCvs() {
        return service.getAllCvs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiSuccessResponse> getCvById(@PathVariable String id) {
        return service.getCvById(id);
    }

    @PutMapping("/update/full-name/{id}")
    public ResponseEntity<ApiSuccessResponse> updateFullName(@PathVariable String id,
                                                             @PathParam("fullName") String fullName) {
        return service.updateFullName(id, fullName);
    }

    @PutMapping("/update/about-me/{id}")
    public ResponseEntity<ApiSuccessResponse> updateAboutMe(@PathVariable String id,
                                                            @PathParam("aboutMe") String aboutMe) {
        return service.updateAboutMe(id, aboutMe);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiSuccessResponse> updateCvById(@PathVariable String id,
                                                           @RequestBody Cv cv) {
        return service.updateCvById(id, cv);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiSuccessResponse> deleteCvById(@PathVariable String id) {
        return service.deleteCvById(id);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiSuccessResponse> deleteAllCvs() {
        return service.deleteAllCvs();
    }
}
