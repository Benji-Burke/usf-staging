package com.revature.facetoface.services;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class FaceService {

    String photo1 = "image3.jpg.jpg";
    String photo2 = "pfp.jpg";
    String photo3 = "image4.jpg";
    String bucket = "aws-freddie-mac";


    AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard().withRegion("us-east-2").build();

    public String compareOnRekognize(String pic1, String pic2) {

        String output = "";
        //Comparing photo 1 and photo 2;
        // 1. First thing is we create the request using compareFaceRequest
        CompareFacesRequest compareFacesRequest = new CompareFacesRequest().withSourceImage(new Image()
                .withS3Object(new S3Object()
                        .withName(photo1).withBucket(bucket))).withTargetImage(new Image()
                .withS3Object(new S3Object()
                        .withName(photo2).withBucket(bucket))).withSimilarityThreshold(80F);

       try {

            CompareFacesResult result = rekognitionClient.compareFaces(compareFacesRequest);
            List<CompareFacesMatch> lists = result.getFaceMatches();

            System.out.println("Detected labels for " + photo1 + " and " + photo2);

            if (!lists.isEmpty()) {
                for (CompareFacesMatch label : lists) {
                    output = label.getSimilarity().toString();
                    System.out.println(label.getFace() + ": Similarity is " + label.getSimilarity().toString());
                    System.out.println("Photo1" + photo1 + "photo2" + photo2 + "similarity score" + label.getSimilarity().toString());

                }
            } else {
                output =("Faces Do not match");
                System.out.println("Faces do not match");
            }
        } catch (Exception e){
           System.out.println("error");
       }
        return output;
    }

    public String compareOneAndTwo(String pic1, String pic3) {

        String output2 = "";
        //Comparing photo 1 and photo 3;
        CompareFacesRequest compareFacesRequest = new CompareFacesRequest().withSourceImage(new Image()
                .withS3Object(new S3Object()
                        .withName(photo1).withBucket(bucket))).withTargetImage(new Image()
                .withS3Object(new S3Object()
                        .withName(photo3).withBucket(bucket))).withSimilarityThreshold(80F);

        try{

            CompareFacesResult result = rekognitionClient.compareFaces(compareFacesRequest);
            List<CompareFacesMatch> lists = result.getFaceMatches();

            System.out.println("Detected labels for " + photo1 + " and " + photo3);

            if (!lists.isEmpty()) {
                for (CompareFacesMatch label : lists) {
                    output2 = label.getSimilarity().toString();
                    System.out.println(label.getFace() + ": Similarity is " + label.getSimilarity().toString());
                    System.out.println("Photo1" + photo1 + "photo3" + photo3 + "similarity score" + label.getSimilarity().toString());
                }
            } else {
               output2 = (photo1 + " " + photo3 + ": FACES DO NOT MATCH");
                System.out.println("Faces do not match!");
            }
        } catch (Exception e){
            System.out.println("error");
        }
        return output2;
    }
}

