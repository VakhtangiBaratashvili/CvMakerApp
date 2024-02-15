package com.example.cvmaker.repository;

import com.example.cvmaker.model.Cv;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CvRepository extends MongoRepository<Cv, String> {
}
