package com.revature.controllers;

import com.amazonaws.services.rekognition.model.CompareFacesMatch;
import com.revature.services.CompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    private CompareService compareService;

    @Autowired
    public ImageController(CompareService compareService) {
        this.compareService = compareService;
    }

    @GetMapping(value = "/image/similarity")
    public List<CompareFacesMatch> getSimilarityScore() { return compareService.toString() }
}
