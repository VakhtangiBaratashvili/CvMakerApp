package com.example.cvmaker.service;

import com.example.cvmaker.dto.ApiSuccessResponse;
import com.example.cvmaker.exception.CvNotFoundException;
import com.example.cvmaker.meta.Education;
import com.example.cvmaker.meta.Experience;
import com.example.cvmaker.model.Cv;
import com.example.cvmaker.repository.CvRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Boolean.TRUE;
import static org.springframework.http.HttpStatus.*;

@Service
@AllArgsConstructor
public class CvServiceImpl implements CvService {

    private final CvRepository repository;

    @Override
    public ResponseEntity<ApiSuccessResponse> addCv(Cv cv) {

        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(repository.insert(cv)).
                status(CREATED).
                statusCode(CREATED.value()).
                build();

        return new ResponseEntity<>(response, CREATED);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> addManyCvs(List<Cv> cvs) {
        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(repository.insert(cvs)).
                status(CREATED).
                statusCode(CREATED.value()).
                build();

        return new ResponseEntity<>(response, CREATED);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> addSocial(String id, String social, String link) {
        Cv cv = repository.findById(id).orElseThrow(() -> new CvNotFoundException("CV Not found"));
        if (social != null && link != null && !social.isBlank() && !link.isBlank()) {
            cv.addSocial(social, link);
            repository.save(cv);
        }
        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(cv).
                status(ACCEPTED).
                statusCode(ACCEPTED.value()).
                build();

        return new ResponseEntity<>(response, ACCEPTED);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> addSkill(String id, String skill) {
        Cv cv = repository.findById(id).orElseThrow(() -> new CvNotFoundException("CV Not found"));
        if (skill != null && !skill.isBlank()) {
            cv.addSkill(skill);
            repository.save(cv);
        }
        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(cv).
                status(ACCEPTED).
                statusCode(ACCEPTED.value()).
                build();

        return new ResponseEntity<>(response, ACCEPTED);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> addExperience(String id, Experience experience) {
        Cv cv = repository.findById(id).orElseThrow(() -> new CvNotFoundException("CV Not found"));
        if (experience != null && experience.getName() != null) {
            cv.addExperience(experience);
            repository.save(cv);
        }
        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(cv).
                status(ACCEPTED).
                statusCode(ACCEPTED.value()).
                build();

        return new ResponseEntity<>(response, ACCEPTED);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> addEducation(String id, Education education) {
        Cv cv = repository.findById(id).orElseThrow(() -> new CvNotFoundException("CV Not found"));
        if (education != null && education.getName() != null) {
            cv.addEducation(education);
            repository.save(cv);
        }
        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(cv).
                status(ACCEPTED).
                statusCode(ACCEPTED.value()).
                build();

        return new ResponseEntity<>(response, ACCEPTED);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> addLanguage(String id, String language, String level) {
        Cv cv = repository.findById(id).orElseThrow(() -> new CvNotFoundException("CV Not found"));
        if (language != null && level != null && !language.isBlank() && !level.isBlank()) {
            cv.addLanguage(language, level);
            repository.save(cv);
        }
        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(cv).
                status(ACCEPTED).
                statusCode(ACCEPTED.value()).
                build();

        return new ResponseEntity<>(response, ACCEPTED);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> getAllCvs() {
        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(repository.findAll()).
                status(OK).
                statusCode(OK.value()).
                build();

        return new ResponseEntity<>(response, OK);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> getCvById(String id) {
        Cv cv = repository.findById(id).orElseThrow(() -> new CvNotFoundException("CV Not found"));

        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(cv).
                status(OK).
                statusCode(OK.value()).
                build();

        return new ResponseEntity<>(response, OK);
    }


    @Override
    public ResponseEntity<ApiSuccessResponse> updateFullName(String id, String fullName) {
        Cv cv = repository.findById(id).orElseThrow(() -> new CvNotFoundException("CV Not found"));
        if (fullName != null && !fullName.isBlank()) {
            cv.setFullName(fullName);
            repository.save(cv);
        }
        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(cv).
                status(ACCEPTED).
                statusCode(ACCEPTED.value()).
                build();

        return new ResponseEntity<>(response, ACCEPTED);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> updateAboutMe(String id, String aboutMe) {
        Cv cv = repository.findById(id).orElseThrow(() -> new CvNotFoundException("CV Not found"));
        if (aboutMe != null && !aboutMe.isBlank()) {
            cv.setAboutMe(aboutMe);
            repository.save(cv);
        }
        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(cv).
                status(ACCEPTED).
                statusCode(ACCEPTED.value()).
                build();

        return new ResponseEntity<>(response, ACCEPTED);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> updateCvById(String id, Cv cv) {
        Cv gottenCv = repository.findById(id).orElseThrow(() -> new CvNotFoundException("CV Not found"));
        if (cv != null) {
            if (cv.getFullName() != null && !cv.getFullName().isBlank()) {
                gottenCv.setFullName(cv.getFullName());
            }
            if (cv.getAddress() != null
                    && cv.getAddress().getCity() != null &&
                    !cv.getAddress().getCity().isBlank()) {
                gottenCv.setAddress(cv.getAddress());
            }
            if (cv.getSocials() != null) {
                gottenCv.setSocials(cv.getSocials());
            }
            if (cv.getAboutMe() != null && !cv.getAboutMe().isBlank()) {
                gottenCv.setAboutMe(cv.getAboutMe());
            }
            if (cv.getSkills() != null && !cv.getSkills().isEmpty()) {
                gottenCv.setSkills(cv.getSkills());
            }
            if (cv.getEducation() != null && !cv.getEducation().isEmpty()) {
                gottenCv.setEducation(cv.getEducation());
            }
            if (cv.getLanguages() != null) {
                gottenCv.setLanguages(cv.getLanguages());
            }
            repository.save(gottenCv);
        }
        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(gottenCv).
                status(ACCEPTED).
                statusCode(ACCEPTED.value()).
                build();

        return new ResponseEntity<>(response, ACCEPTED);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> deleteCvById(String id) {
        Cv cv = repository.findById(id).orElseThrow(() -> new CvNotFoundException("CV Not found"));
        repository.deleteById(id);

        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(cv).
                status(OK).
                statusCode(OK.value()).
                build();

        return new ResponseEntity<>(response, OK);
    }

    @Override
    public ResponseEntity<ApiSuccessResponse> deleteAllCvs() {
        List<Cv> cvs = repository.findAll();
        repository.deleteAll();
        ApiSuccessResponse response = ApiSuccessResponse.
                builder().
                success(TRUE).
                data(cvs).
                status(OK).
                statusCode(OK.value()).
                build();

        return new ResponseEntity<>(response, OK);
    }
}
