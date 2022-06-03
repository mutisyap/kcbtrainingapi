package com.pmutisya.kcbapi.controller;

import com.pmutisya.kcbapi.domain.Cat;
import com.pmutisya.kcbapi.service.CatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CatController {
    private Logger logger = LoggerFactory.getLogger(CatController.class);

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @PostMapping("/cats")
    public Cat createCat(@RequestBody Cat cat){
        logger.debug("Received cat : {}", cat);

        // do saving cats

        return catService.save(cat);
    }

    @PutMapping("/cats/{id}")
    public Cat updateCat(@RequestBody Cat cat, @PathVariable Long id){
        logger.debug("Request to update cat : {}, with id : {}", cat, id);

        // get by id

        return catService.save(cat);
    }

    @GetMapping("/cats/{id}")
    public Optional<Cat> findOne(@PathVariable Integer id){
        logger.debug("REST request to get cat with id : {}", id);
        return catService.findById(id);
    }

    @GetMapping("/cats")
    public List<Cat> findAll(){
        logger.debug("REST request to get all cats");
        return catService.findAll();
    }
}
