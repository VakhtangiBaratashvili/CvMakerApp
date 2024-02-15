package com.example.cvmaker.model;

import com.example.cvmaker.meta.Address;
import com.example.cvmaker.meta.Education;
import com.example.cvmaker.meta.Experience;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Data
@Document
public class Cv {
    @Id
    private String id;
    private String fullName;
    private Address address;
    private Map<String, String> socials;
    private String aboutMe;
    private List<String> skills;
    private List<Experience> experience;
    private List<Education> education;
    private Map<String, String> languages;

    public Cv(String fullName,
              Address address,
              Map<String, String> socials,
              String aboutMe,
              List<String> skills,
              List<Experience> experience,
              List<Education> education,
              Map<String, String> languages) {

        this.fullName = fullName;
        this.address = address;
        this.socials = socials;
        this.aboutMe = aboutMe;
        this.skills = skills;
        this.experience = experience;
        this.education = education;
        this.languages = languages;
    }

    public void addSocial(String social, String link) {
        if (!this.socials.containsKey(social)) {
            this.socials.put(social, link);
        }
    }

    public void addSkill(String skill) {
        if (!this.skills.contains(skill)) {
            this.skills.add(skill);
        }
    }

    public void addExperience(Experience experience) {
        if (!this.experience.contains(experience)) {
            this.experience.add(experience);
        }
    }

    public void addEducation(Education education) {
        if (!this.education.contains(education)) {
            this.education.add(education);
        }
    }

    public void addLanguage(String language, String level) {
        if (!this.languages.containsKey(language)) {
            this.languages.put(language, level);
        }
    }
}
