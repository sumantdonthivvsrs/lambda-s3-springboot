package com.vvsrs.springLambda.springLambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Util {

    public static void logEnvironment(Object event, Gson gson)
    {
        log.info("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        log.info("EVENT: " + gson.toJson(event));
        log.info("EVENT TYPE: " + event.getClass().toString());
    }
}
