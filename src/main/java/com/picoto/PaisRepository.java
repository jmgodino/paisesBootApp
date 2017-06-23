package com.picoto;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends MongoRepository<Pais, Integer> {

    public Pais findById(Integer id);
    
    public List<Pais> findByDes(String des);

}
