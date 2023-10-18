package com.hscoreserver.hscorespring.redirection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedirectionRepository extends MongoRepository<Redirection, String> {

}
