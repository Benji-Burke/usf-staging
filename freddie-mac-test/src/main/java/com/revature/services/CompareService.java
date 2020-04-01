package com.revature.services;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.DetectModerationLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectModerationLabelsResult;
import com.amazonaws.services.rekognition.model.Image;
import com.revature.controllers.AwsRekognitionController;
import io.netty.buffer.ByteBuf;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.ByteBuffer;

@Service
public class CompareService {
//
//    String photo1 = "";
//    String photo2 = "";
//    String photo3 = "";


    private
    AmazonRekognition rekognitionClient;


    public CompareService(AmazonRekognition rekognitionClient) {
        this.rekognitionClient = rekognitionClient;
    }

    public DetectModerationLabelsResult detectionModerationLabels(MultipartFile image) throws IOException {
        DetectModerationLabelsRequest request = new DetectModerationLabelsRequest()
                .withImage(new Image().withBytes(ByteBuffer.wrap(image.getBytes())));

        return rekognitionClient.detectModerationLabels(request);
    }

}
