package com.revature.services;

import com.amazonaws.services.dlm.model.ResourceNotFoundException;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompareService {

    private AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard().withRegion("us-east-2").build();

    {
        String photo1 = "image3.jpg.jpg";
        String photo2 = "pfp.jpg";
        String photo3 = "image4.jpg";
        String bucket = "aws-freddie-mac";
    }

    @Autowired
    public CompareService(AmazonRekognition rekognitionClient) {
        super();
        this.rekognitionClient= rekognitionClient;
    }

    @Transactional(readOnly = true)
    public List<Image> getAll() throws ResourceNotFoundException {
        Iterable<Image> i= rekognitionClient.compareFacesRequest
    }




}
