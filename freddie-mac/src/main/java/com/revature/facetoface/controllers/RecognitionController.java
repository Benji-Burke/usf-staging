package com.revature.facetoface.controllers;

import com.revature.facetoface.entities.Confidence;
import com.revature.facetoface.services.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.awt.*;
import java.util.HashSet;

@RestController
@RequestMapping("/face")
public class RecognitionController {

    private FaceService faceService;




    @Autowired
    public RecognitionController(FaceService faceService) {
        this.faceService = faceService ;
    }

    @GetMapping("/test")
    public @ResponseBody String test() {
        return faceService.toString();
    }


//    @RequestMapping("/confidence")
//    public Confidence getConfidence(){
//        return faceService.
//    }


}