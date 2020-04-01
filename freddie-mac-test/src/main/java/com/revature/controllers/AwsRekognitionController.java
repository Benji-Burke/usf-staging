package com.revature.controllers;

import com.revature.services.CompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/compare")
public class AwsRekognitionController {

    private CompareService compareService;


    @Autowired
    public AwsRekognitionController(CompareService compareService) {
        this.compareService = compareService;
    }

    @PostMapping("/image/sig")
    public Object grabData(@RequestParam MultipartFile image) throws IOException {
        return ResponseEntity.ok(compareService.detectionModerationLabels(image));
    }

    public CompareService getCompareService() {
        return compareService;
    }
}
