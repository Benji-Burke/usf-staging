package com.revature.facetoface.controllers;

import com.revature.facetoface.services.FaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
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


    @RequestMapping("/confidence")
    public String getConfidence(){
        return faceService.compareOnRekognize("image3.jpg.jpg","pfp.jpg");
    }

    @RequestMapping("/confidence2")
    public String getSecond(){
        return faceService.compareOneAndTwo("image3.jpg.jpg", "image4.jpg");
    }
}