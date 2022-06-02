package com.pmutisya.kcbapi.controller;

import com.pmutisya.kcbapi.domain.Cat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {
    private Logger logger = LoggerFactory.getLogger(CatController.class);
    @PostMapping("/cats")
    public Cat createCat(@RequestBody Cat cat){
        logger.debug("Received cat : {}", cat);

        // do saving cats

        return cat;
    }
}
