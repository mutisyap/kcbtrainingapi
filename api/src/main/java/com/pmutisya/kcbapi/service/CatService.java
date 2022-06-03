package com.pmutisya.kcbapi.service;

import com.pmutisya.kcbapi.domain.Cat;
import com.pmutisya.kcbapi.repository.CatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatService {
    private final Logger logger = LoggerFactory.getLogger(CatService.class);

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }


    public Cat save(Cat cat){
        logger.info("Request to save cat :{}", cat);
        return catRepository.save(cat);
    }

    public Optional<Cat> findById(Integer id){
        logger.info("Request to find cat with id : {}", id);
        return catRepository.findById(id);
    }

    public List<Cat> findAll(){
        logger.info("Request to find all cats");
        return catRepository.findAll();
    }
}
