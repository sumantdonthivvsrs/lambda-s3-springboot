package com.vvsrs.springLambda.springLambda;

import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.lambda.runtime.events.models.s3.S3EventNotification;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Slf4j
@Component("awsLambdaS3Function")
public class LambdaFunction implements Function<S3Event,String>{


    @Override
    public String apply(S3Event s3Event) {
        log.info("Entering functional interface apply function");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        S3EventNotification.S3EventNotificationRecord record = s3Event.getRecords().get(0);
        String srcBucket = record.getS3().getBucket().getName();
        // Object key may have spaces or unicode non-ASCII characters.
        String srcKey = record.getS3().getObject().getUrlDecodedKey();
        log.info("RECORD: " + record);
        log.info("SOURCE BUCKET: " + srcBucket);
        log.info("SOURCE KEY: " + srcKey);
        Util.logEnvironment(s3Event, gson);
        return "Successly Completed lambda Execution";
    }
}
