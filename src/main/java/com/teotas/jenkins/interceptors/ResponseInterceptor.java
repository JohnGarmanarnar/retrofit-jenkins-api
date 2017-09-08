package com.teotas.jenkins.interceptors;

import com.teotas.jenkins.JenkinsAPIConnection;
import okhttp3.*;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;



public class ResponseInterceptor implements Interceptor {
    private JenkinsAPIConnection connection;

    public ResponseInterceptor(JenkinsAPIConnection connection){
        this.connection = connection;
    }

    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Response returnedResponse = chain.proceed(original);

        if(returnedResponse.header("Content-Type").toLowerCase().contains("xml")){
            String xmlToConvert = returnedResponse.body().string();
            JSONObject convertedXML = XML.toJSONObject(xmlToConvert);
            ResponseBody newBody = ResponseBody.create(MediaType.parse("application/json"), convertedXML.toString());
            returnedResponse = returnedResponse.newBuilder().body(newBody).build();
        }

        return returnedResponse;
    }
}
