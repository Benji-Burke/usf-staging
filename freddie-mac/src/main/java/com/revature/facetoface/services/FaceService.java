package com.revature.facetoface.services;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FaceService {



    String photo1 = "image3.jpg.jpg";
    String photo2 = "pfp.jpg";
    String photo3 = "image4.jpg";
    String bucket = "aws-freddie-mac";


    AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard().withRegion("us-east-2").build();



    //Comparing photo 1 and photo 2;
   CompareFacesRequest compareFacesRequest = new CompareFacesRequest().withSourceImage(new Image()
            .withS3Object(new S3Object()
                    .withName(photo1).withBucket(bucket))).withTargetImage(new Image()
            .withS3Object(new S3Object()
                    .withName(photo2).withBucket(bucket))).withSimilarityThreshold(80F);

    {

        CompareFacesResult result= rekognitionClient.compareFaces(compareFacesRequest);
        List<CompareFacesMatch> lists= result.getFaceMatches();

        System.out.println("Detected labels for " + photo1+ " and "+photo2);

        if(!lists.isEmpty()){
            for (CompareFacesMatch label: lists) {
                System.out.println(label.getFace() + ": Similarity is " + label.getSimilarity().toString());
                System.out.println("Photo1" + photo1 + "photo2" + photo2 +"similarity score" + label.getSimilarity().toString());
            }
        }else{
            System.out.println("Faces Does not match");
        }

    }




}

